let map: Map<any, any[]> = new Map<any, any[]>();

function createMap(key: any, val: any): void {
    if (map.has(key)) {
        let arr: any[] | undefined = map.get(key);
        if (arr) {
            arr.push(val);
            map.set(key, arr);
        }
    } else {
        let arr: any[] = [];
        arr.push(val);
        map.set(key, arr);
    }
    console.log(map);
}

/* let errors={}
if (isEmpty(addressDTO) || isEmpty(addressDTO.pincode) || isEmpty(addressDTO.address)) {
if(errors[applicantDTO?.applicantType]){
        errors[applicantDTO?.applicantType].push(ERROR_CODE.RESIDENTIAL_ADDRESS_NOT_FOUND);
    }else{
        errors[applicantDTO?.applicantType]=[]
        errors[applicantDTO?.applicantType].push(ERROR_CODE.RESIDENTIAL_ADDRESS_NOT_FOUND)
    }
} */
function calling(addressDTO,ERROR_CODE,applicantDTO):void{
let errors :Map<string, string[]> = new Map<string, string[]>();
if (isEmpty(addressDTO) || isEmpty(addressDTO.pincode) || isEmpty(addressDTO.address)) {
if(errors.has(applicantDTO?.applicantType)){
    
    let array_of_errors :string[]= errors.get(applicantDTO.applicantType)
    array_of_errors.push(ERROR_CODE.RESIDENTIAL_ADDRESS_NOT_FOUND)
    map.set(applicantDTO.applicantType,array_of_errors)
    
        //errors[applicantDTO?.applicantType].push(ERROR_CODE.RESIDENTIAL_ADDRESS_NOT_FOUND);
    }else{
        let array_of_errors :string[]=[]
        array_of_errors.push(ERROR_CODE.RESIDENTIAL_ADDRESS_NOT_FOUND)
        errors.set(applicantDTO.applicantType,array_of_errors)
        
    }
}
}

import {Inject, Injectable, Logger, forwardRef} from '@nestjs/common';
import {ADDRESS_TYPE, APPLICANT_TYPE, ActionType, LoginStage, STAGE_NAME, StoryBoard} from 'src/util/enums.util';
import {FunctionalException} from '@kaiju-lib/node-common';
import {isEmpty, isNotEmpty} from 'class-validator';
import {ERROR_CODE} from 'src/util/error-constants';
import {ApplicantDTO} from 'src/dto/applicant.dto';
import {AddressDTO} from 'src/dto/address.dto';
import {LoanValidatorBaseService} from 'src/util/loan-validator-base.service';
import {LoanDTO} from 'src/dto/loan.dto';
import {KycDTO} from 'src/dto/kyc.dto';
import {EmploymentDetailDTO} from 'src/dto/employment-detail.dto';
import {BankingDetailDTO} from 'src/dto/banking-detail.dto';
import {InvestmentInformationDTO} from 'src/dto/investment-information.dto';
import {StageStoryboardRecomendationDTO} from 'src/dto/stage-storyboard-recomendation.dto';
import {OtherDetailSectionDTO} from 'src/dto/other-detail-section.dto';
import {STATIC_MASTER_DATA} from 'src/util/static-master-data.enum';
import {ApplicantService} from './applicant.service';
import {KycService} from './kyc.service';
import {DOCUMENT_TYPE} from 'src/util/document-type.enum';
import {BasicInformationSectionService} from './basic-information-section.service';
import {AddressService} from './address.service';
import {EmploymentDetailService} from './employment-detail.service';
import {BankingDetailService} from './banking-detail.service';
import {ReceiptService} from './receipt.service';
import {StageStoryboardRecomendationService} from './stage-storyboard-recomendation.service';
import {BranchProductMappingService} from './branch-product-mapping.service';
import {BranchService} from './branch.service';
import {SystemDateService} from './system-date.service';
import {ProductService} from './product.service';

@Injectable()
export class LoanStageValidatorService extends LoanValidatorBaseService {
  private readonly logger = new Logger(LoanStageValidatorService.name);

  @Inject(forwardRef(() => ApplicantService))
  private readonly applicantService: ApplicantService;

  @Inject(forwardRef(() => KycService))
  private readonly kycService: KycService;

  @Inject(forwardRef(() => BasicInformationSectionService))
  private readonly basicInformationSectionService: BasicInformationSectionService;

  @Inject(forwardRef(() => AddressService))
  private readonly addressService: AddressService;

  @Inject(forwardRef(() => EmploymentDetailService))
  private readonly employmentDetailService: EmploymentDetailService;

  @Inject(forwardRef(() => BankingDetailService))
  private readonly bankingDetailService: BankingDetailService;

  @Inject(forwardRef(() => ReceiptService))
  private readonly receiptService: ReceiptService;

  @Inject(forwardRef(() => StageStoryboardRecomendationService))
  private readonly stageStoryboardRecomendationService: StageStoryboardRecomendationService;

  // inject system date service
  @Inject(forwardRef(() => SystemDateService)) private readonly systemDateService: SystemDateService;

  // inject branch service
  @Inject(forwardRef(() => BranchService)) private readonly branchService: BranchService;

  // inject branch product mapping service
  @Inject(forwardRef(() => BranchProductMappingService))
  private readonly branchProductMappingService: BranchProductMappingService;

  // inject product service
  @Inject(forwardRef(() => ProductService)) private readonly productService: ProductService;

  async validate(section: string, actionType: ActionType, object: any, subStage?: string): Promise<any> {
    switch (section) {
      case LoginStage.SOURCING:
        await this.sourcing(section, actionType, object, subStage);
        break;
      case LoginStage.KYC:
        await this.kyc(section, actionType, object, subStage);
        break;
      case LoginStage.EMPLOYMENT_DETAIL:
        await this.employmentDetail(section, actionType, object, subStage);
        break;
      case LoginStage.BANKING_DETAIL:
        await this.bankingDetail(section, actionType, object, subStage);
        break;
      case LoginStage.REFERENCE:
        await this.reference(section, actionType, object, subStage);
        break;
      case LoginStage.INVESTMENT_INFORMATION:
        await this.investmentInformation(section, actionType, object, subStage);
        break;
      case LoginStage.OTHER_DOCUMENT:
        await this.otherDocument(section, actionType, object, subStage);
        break;
      case LoginStage.STORY_BOARD_RECOMMENDATION:
        await this.storyBoardOrSalesRecommendation(section, actionType, object, subStage);
        break;
      case LoginStage.NAME_CONTACT:
        await this.nameContact(section, actionType, object, subStage);
        break;
      case LoginStage.OTHER_DETAIL:
        await this.otherDetails(section, actionType, object, subStage);
        break;
      case LoginStage.RESIDENTIAL_ADDRESS:
        await this.residentialAddress(section, actionType, object, subStage);
        break;
      case LoginStage.COLLATERAL_PROPERTY:
        await this.collateralProperty(section, actionType, object, subStage);
        break;
      case STAGE_NAME.LOGIN:
        await this.stageValidation(section, actionType, object, subStage);
        break;
      case LoginStage.CORPORATE_BASIC_INFO:
        await this.corporateBasicInfo(section, actionType, object, subStage);
        break;
      case LoginStage.CORPORATE_ADDRESS:
        await this.corporateAddress(section, actionType, object, subStage);
        break;
      case LoginStage.CORPORATE_OTHER_DETAIL:
        await this.corporateOtherDetail(section, actionType, object, subStage);
        break;
      case LoginStage.CORPORATE_DIRECTOR:
        await this.corporateDirector(section, actionType, object, subStage);
        break;
    }
  }

  async sourcing(section: string, actionType: ActionType, object: LoanDTO, subStage?: string) {
    let errors: string[] = [];

    if (subStage === LoginStage.QDE || subStage === LoginStage.DDE) {
      if (isEmpty(object.product)) {
        errors.push(ERROR_CODE.LOAN_PRODUCT_NOT_FOUND);
      }

      if (isEmpty(object.amount)) {
        errors.push(ERROR_CODE.LOAN_LOAN_AMOUNT_NOT_FOUND);
      }

      if (isEmpty(object.tenure)) {
        errors.push(ERROR_CODE.LOAN_LOAN_TENOR_NOT_FOUND);
      }

      if (isEmpty(object.salesAgent)) {
        errors.push(ERROR_CODE.LOAN_SALES_AGENT_NOT_FOUND);
      }

      // if (isEmpty(object.salesManager)) {
      //   errors.push(ERROR_CODE.LOAN_SALES_MANAGER_NOT_FOUND);
      // }

      if (isEmpty(object.branch)) {
        errors.push(ERROR_CODE.LOAN_BRANCH_NOT_FOUND);
      }

      errors.push(...(await this.validateBranchProductMapping(object)));
    }

    if (subStage === LoginStage.DDE) {
      if (isEmpty(object.smChannelType)) {
        errors.push(ERROR_CODE.LOAN_CHANNEL_TYPE_NOT_FOUND);
      }

      if (object.smChannelType === STATIC_MASTER_DATA.CHANNEL_TYPE_DSA && isEmpty(object.smChannelName)) {
        errors.push(ERROR_CODE.LOAN_CHANNEL_NAME_NOT_FOUND);
      }
    }

    if (errors.length > 0) {
      this.logger.debug('Errors found in validating Sourcing ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async validateBranchProductMapping(object: LoanDTO) {
    // const branch = await this.branchService.findByUid(object.branch.uid);
    const product = await this.productService.findByUid(object.product.uid);

    const systemDate = await this.systemDateService.getCurrentSystemDate();
    const currentSystemDate = new Date(systemDate.date);

    const [, count] = await this.branchProductMappingService.search(
      0,
      1,
      {},
      {
        'branch.uid': object.branch.uid,
        isActive: true,
      },
    );
    const [branchProductMappings] = await this.branchProductMappingService.search(
      0,
      count,
      {},
      {
        'branch.uid': object.branch.uid,
        isActive: true,
      },
    );

    for (let i = 0; i < branchProductMappings.length; i++) {
      if (
        branchProductMappings[i].applicableFrom <= currentSystemDate &&
        (isEmpty(branchProductMappings[i].applicableTo) || branchProductMappings[i].applicableTo >= currentSystemDate)
      ) {
        const productType = branchProductMappings[i].productType;
        if (product.productType.uid === productType.uid) {
          return [];
        }
      }
    }

    return [ERROR_CODE.LOAN_BRANCH_PRODUCT_MAPPING_NOT_FOUND];
  }

  async kyc(section: string, actionType: ActionType, object: KycDTO, subStage?: string) {
    let errors: string[] = [];
    // if (isEmpty(object.docNo)) {
    //   errors.push(ERROR_CODE.DOCUMENT_NUMBER_REQUIRED);
    // }
    if (isEmpty(object.docType.uid)) {
      errors.push(ERROR_CODE.DOCUMENT_TYPE_REQUIRED);
    }
    if (errors.length > 0) {
      this.logger.debug('Errors found in validating Sourcing ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async employmentDetail(section: string, actionType: ActionType, object: EmploymentDetailDTO, subStage?: string) {
    let errors: string[] = [];
    if (isEmpty(object.smEmploymentNature)) {
      errors.push(ERROR_CODE.EMPLOYMENT_NATURE_REQUIRED);
    }
    if (isEmpty(object.industry)) {
      errors.push(ERROR_CODE.INDUSTRY_TYPE_REQUIRED);
    }
    if (isEmpty(object.orgName)) {
      errors.push(ERROR_CODE.ORG_NAME_REQUIRED);
    }
    if (isEmpty(object.occupation)) {
      errors.push(ERROR_CODE.OCCUPATION_REQUIRED);
    }
    if (isEmpty(object.smIncorporationYear)) {
      errors.push(ERROR_CODE.INCORPORATION_YEAR_REQUIRED);
    }
    if (isEmpty(object.expInYear)) {
      errors.push(ERROR_CODE.EXP_IN_YEAR_REQUIRED);
    }
    if (isEmpty(object.netIncomeMonth)) {
      errors.push(ERROR_CODE.NET_INCOME_MONTH_REQUIRED);
    }
    if (isEmpty(object.expenseMonth)) {
      errors.push(ERROR_CODE.EXPENSE_MONTH_REQUIRED);
    }
    if (isEmpty(object.otherIncomeMonth)) {
      errors.push(ERROR_CODE.OTHER_INCOME_MONTH_REQUIRED);
    }
    if (isEmpty(object.netIncomeYear)) {
      errors.push(ERROR_CODE.NET_INCOME_YEARLY_REQUIRED);
    }
    if (object.smEmploymentNature !== STATIC_MASTER_DATA.EMPLOYMENT_NATURE_SALARIED) {
      if (isEmpty(object.smBusinessManagedBy)) {
        errors.push(ERROR_CODE.BUSINESS_MANAGE_BY_REQUIRED);
      }
      if (isEmpty(object.smBusinessSeasonality)) {
        errors.push(ERROR_CODE.BUSINESS_SEASONALITY_REQUIRED);
      }
    }
    if (isEmpty(object.smNoOfEmployee)) {
      errors.push(ERROR_CODE.No_OF_EMPLOYEE_REQUIRED);
    }

    if (object.applicant.applicantType === APPLICANT_TYPE.PRIMARY) {
      if (isEmpty(object.loanDocuments) || object.loanDocuments.length === 0) {
        errors.push(ERROR_CODE.BUSINESS_PROOF_NOT_FOUND);
      }
    }

    //address
    if (isEmpty(object.premisesAddress)) {
      errors.push(ERROR_CODE.ADDRESS_IS_REQUIRED);
    } else {
      if (isEmpty(object.premisesAddress.address)) {
        errors.push(ERROR_CODE.ADDRESS_IS_REQUIRED);
      }
      if (isEmpty(object.premisesAddress.pincode)) {
        errors.push(ERROR_CODE.PINCODE_IS_REUIRED);
      }
      if (isEmpty(object.premisesAddress.city)) {
        errors.push(ERROR_CODE.CITY_IS_REUIRED);
      }
      if (isEmpty(object.premisesAddress.latitude)) {
        errors.push(ERROR_CODE.LATITUDE_IS_REUIRED);
      }
      if (isEmpty(object.premisesAddress.longitude)) {
        errors.push(ERROR_CODE.LONGITUDE_IS_REUIRED);
      }
    }

    if (errors.length > 0) {
      this.logger.debug('Errors found in validating Sourcing ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async bankingDetail(section: string, actionType: ActionType, object: BankingDetailDTO, subStage?: string) {
    let errors: string[] = [];
    if (isEmpty(object.accountHolderName)) {
      errors.push(ERROR_CODE.ACCOUNT_HOLDER_NAME_REQUIRED);
    }
    if (isEmpty(object.ifsc)) {
      errors.push(ERROR_CODE.IFSC_REQUIRED);
    }
    if (isEmpty(object.smAccountType)) {
      errors.push(ERROR_CODE.ACCOUNT_TYPE_REQUIRED);
    }
    if (isEmpty(object.accountNo)) {
      errors.push(ERROR_CODE.ACCOUNT_NO_REQUIRED);
    }
    if (object.applicant.applicantType !== APPLICANT_TYPE.CORPORATE_CO_APPLICANT) {
      if (isEmpty(object.loanDocuments) || object.loanDocuments.length === 0) {
        errors.push(ERROR_CODE.BANK_STATEMENT_NOT_FOUND);
      }
    }
    if (errors.length > 0) {
      this.logger.debug('Errors found in validating Sourcing ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async reference(section: string, actionType: ActionType, object: AddressDTO, subStage?: string) {
    let errors: string[] = [];
    if (isEmpty(object.applicant)) {
      errors.push(ERROR_CODE.APPLICANT_FIRST_NAME_NOT_FOUND);
    } else {
      if (isEmpty(object.applicant.firstName)) {
        errors.push(ERROR_CODE.APPLICANT_FIRST_NAME_NOT_FOUND);
      }
      if (isEmpty(object.applicant.lastName)) {
        errors.push(ERROR_CODE.APPLICANT_LAST_NAME_NOT_FOUND);
      }
      if (isEmpty(object.applicant.mobileNo)) {
        errors.push(ERROR_CODE.APPLICANT_MOBILE_NOT_FOUND);
      }
      if (isEmpty(object.applicant.smRelationship)) {
        errors.push(ERROR_CODE.RELATIONSHIP_REUIRED);
      }
    }
    if (isEmpty(object.address)) {
      errors.push(ERROR_CODE.ADDRESS_IS_REQUIRED);
    }
    if (isEmpty(object.pincode)) {
      errors.push(ERROR_CODE.PINCODE_IS_REUIRED);
    }
    if (isEmpty(object.city)) {
      errors.push(ERROR_CODE.CITY_IS_REUIRED);
    }
    // if (isEmpty(object.latitude)) {
    //   errors.push(ERROR_CODE.LATITUDE_IS_REUIRED);
    // }
    // if (isEmpty(object.longitude)) {
    //   errors.push(ERROR_CODE.LONGITUDE_IS_REUIRED);
    // }
    if (errors.length > 0) {
      this.logger.debug('Errors found in validating Sourcing ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async investmentInformation(
    section: string,
    actionType: ActionType,
    object: InvestmentInformationDTO,
    subStage?: string,
  ) {
    // throw new FunctionalException(['array of faild validations']);
  }
  async otherDocument(section: string, actionType: ActionType, object: any, subStage?: string) {
    // throw new FunctionalException(['array of faild validations']);
  }
  async storyBoardOrSalesRecommendation(
    section: string,
    actionType: ActionType,
    object: StageStoryboardRecomendationDTO[],
    subStage?: string,
  ) {
    let errors: string[] = [];
    for (let storyboard of object) {
      if (isEmpty(storyboard.smSectionType)) {
        errors.push(ERROR_CODE.SECTION_TYPE_REQUIRED);
      } else if (storyboard.smSectionType == StoryBoard.SALES_RECOMMENDATION) {
        if (isEmpty(storyboard.recommendationDate)) {
          errors.push(ERROR_CODE.RECOMMENDATION_DATE);
        }
        if (isEmpty(storyboard.recommendedBy.uid)) {
          errors.push(ERROR_CODE.RECOMMENDATION_BY);
        }
        if (isEmpty(storyboard.recommendation)) {
          errors.push(ERROR_CODE.RECOMMENDATION);
        }
      } else {
        if (isEmpty(storyboard.storyBoard)) {
          errors.push(ERROR_CODE.STORY_BOARD);
        }
      }
    }
    if (errors.length > 0) {
      this.logger.debug('Errors found in validating Sales Story Board ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async nameContact(section: string, actionType: ActionType, object: ApplicantDTO, subStage?: string) {
    let errors: string[] = [];

    if (isEmpty(object.smSalutation)) {
      errors.push(ERROR_CODE.APPLICANT_SALUTATION_NOT_FOUND);
    }

    if (isEmpty(object.smGender)) {
      errors.push(ERROR_CODE.APPLICANT_GENDER_NOT_FOUND);
    }

    if (isEmpty(object.firstName)) {
      errors.push(ERROR_CODE.APPLICANT_FIRST_NAME_NOT_FOUND);
    }

    if (isEmpty(object.lastName)) {
      errors.push(ERROR_CODE.APPLICANT_LAST_NAME_NOT_FOUND);
    }

    if (object.applicantType !== APPLICANT_TYPE.DEPENDANT) {
      if (isEmpty(object.dateOfBirth)) {
        errors.push(ERROR_CODE.APPLICANT_DOB_NOT_FOUND);
      }

      if (isEmpty(object.mobileNo)) {
        errors.push(ERROR_CODE.APPLICANT_MOBILE_NOT_FOUND);
      }

      if (isEmpty(object.applicantUrl)) {
        errors.push(ERROR_CODE.APPLICANT_URL_NOT_FOUND);
      }
    }

    // if (isEmpty(object.applicantThumbUrl)) {
    //   errors.push(ERROR_CODE.APPLICANT_THUMB_URL_NOT_FOUND);
    // }

    // if (isEmpty(object.ageAsOfLoanCreation)) {
    //   errors.push(ERROR_CODE.APPLICANT_AGE_AS_ON_NOT_FOUND);
    // }

    if (isNotEmpty(object.applicantType)) {
      if (
        (isEmpty(object.loanDocuments) || !object.loanDocuments?.length) &&
        (object.applicantType === APPLICANT_TYPE.PRIMARY ||
          object.applicantType === APPLICANT_TYPE.CO_APPLICANT ||
          object.applicantType === APPLICANT_TYPE.GUARANTOR)
      ) {
        errors.push(ERROR_CODE.APPLICANT_DOB_PROOF_NOT_FOUND);
      }

      if (
        object.applicantType === APPLICANT_TYPE.CO_APPLICANT ||
        object.applicantType === APPLICANT_TYPE.GUARANTOR ||
        object.applicantType === APPLICANT_TYPE.DEPENDANT
      ) {
        if (isEmpty(object.smRelationship)) {
          errors.push(ERROR_CODE.APPLICANT_RELATION_NOT_FOUND);
        }
      }
    } else {
      errors.push(ERROR_CODE.APPLICANT_TYPE_NOT_FOUND);
    }

    if (errors.length > 0) {
      this.logger.debug('Errors found in validating Name and Contact in Basic Information ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async residentialAddress(section: string, actionType: ActionType, object: AddressDTO, subStage?: string) {
    let errors: string[] = [];

    if (isEmpty(object.applicant) || isEmpty(object.applicant.uid)) {
      errors.push(ERROR_CODE.APPLICANT_NOT_FOUND);
    }

    if (isEmpty(object.address)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_NOT_FOUND);
    }

    if (isEmpty(object.pincode)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_PINCODE_NOT_FOUND);
    }

    if (isEmpty(object.city)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_CITY_NOT_FOUND);
    }

    if (isEmpty(object.smAddressType)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_TYPE_NOT_FOUND);
    }

    // if (isEmpty(object.latitude)) {
    //   errors.push(ERROR_CODE.PROPERTY_ADDRESS_LAT_NOT_FOUND);
    // }

    // if (isEmpty(object.longitude)) {
    //   errors.push(ERROR_CODE.PROPERTY_ADDRESS_LONG_NOT_FOUND);
    // }

    // if (isEmpty(object.documents) || object.documents.length === 0) {
    //   errors.push(ERROR_CODE.PROPERTY_ADDRESS_PROOF_NOT_FOUND);
    // }

    if (
      (isEmpty(object.loanDocuments) || !object.loanDocuments?.length) &&
      (object.applicant.applicantType === APPLICANT_TYPE.PRIMARY ||
        object.applicant.applicantType === APPLICANT_TYPE.CO_APPLICANT ||
        object.applicant.applicantType === APPLICANT_TYPE.GUARANTOR) &&
      (isEmpty(section) || section !== LoginStage.OTHER_DETAIL)
    ) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_PROOF_NOT_FOUND);
    }

    if (errors.length > 0) {
      this.logger.debug('Errors found in validating address ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async otherDetails(section: string, actionType: ActionType, object: OtherDetailSectionDTO, substage: string) {
    if (substage === LoginStage.DDE) {
      await this.residentialAddress(section, actionType, object.permanentAddress, substage);
      await this.otherApplicantDetail(section, actionType, object.applicant, substage);
    }
  }

  async otherApplicantDetail(section: string, actionType: ActionType, object: ApplicantDTO, substage: string) {
    let errors: string[] = [];

    if (substage === LoginStage.DDE) {
      if (isEmpty(object.smMaritalStatus)) {
        errors.push(ERROR_CODE.APPLICANT_MARITIAL_STATUS_NOT_FOUND);
      }

      if (isEmpty(object.fatherOrSpouseName)) {
        errors.push(ERROR_CODE.APPLICANT_FATHER_SPOUSE_NOT_FOUND);
      }

      if (isEmpty(object.smEducation)) {
        errors.push(ERROR_CODE.APPLICANT_EDUCATION_NOT_FOUND);
      }

      if (isEmpty(object.university)) {
        errors.push(ERROR_CODE.APPLICANT_UNIVERSITY_NOT_FOUND);
      }

      if (isEmpty(object.placeOfBirth)) {
        errors.push(ERROR_CODE.APPLICANT_BIRTH_PLACE_NOT_FOUND);
      }

      if (isEmpty(object.smReligion)) {
        errors.push(ERROR_CODE.APPLICANT_RELIGION_NOT_FOUND);
      }

      if (isEmpty(object.smCasteCategory)) {
        errors.push(ERROR_CODE.APPLICANT_CATEGORY_NOT_FOUND);
      } else {
        if (
          object.applicantType === APPLICANT_TYPE.PRIMARY &&
          (object.smCasteCategory === STATIC_MASTER_DATA.CATEGORY_SC ||
            object.smCasteCategory === STATIC_MASTER_DATA.CATEGORY_ST ||
            object.smCasteCategory === STATIC_MASTER_DATA.CATEGORY_OBC)
        ) {
          // if (isEmpty(object.documents) || object.documents.length === 0) {
          //   errors.push(ERROR_CODE.CATEGORY_PROOF_NOT_FOUND);
          // }
          if (isEmpty(object.loanDocuments) || object.loanDocuments.length === 0) {
            errors.push(ERROR_CODE.CATEGORY_PROOF_NOT_FOUND);
          }
        }
      }
    }

    if (errors.length > 0) {
      this.logger.debug('Errors found in validating applicant ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async collateralProperty(section: string, actionType: ActionType, object: AddressDTO, substage: string) {
    if (substage === LoginStage.DDE) {
      let errors: string[] = [];

      if (isEmpty(object.isPropertySelected)) {
        errors.push('radio button not selected');
      } else {
        if (object.isPropertySelected) {
          if (isEmpty(object.address)) {
            errors.push(ERROR_CODE.PROPERTY_ADDRESS_NOT_FOUND);
          }

          if (isEmpty(object.pincode)) {
            errors.push(ERROR_CODE.PROPERTY_ADDRESS_PINCODE_NOT_FOUND);
          }

          if (isEmpty(object.city)) {
            errors.push(ERROR_CODE.PROPERTY_ADDRESS_CITY_NOT_FOUND);
          }

          if (isEmpty(object.propertyType)) {
            errors.push(ERROR_CODE.PROPERTY_ADDRESS_TYPE_NOT_FOUND);
          }

          if (isEmpty(object.latitude)) {
            errors.push(ERROR_CODE.PROPERTY_ADDRESS_LAT_NOT_FOUND);
          }

          if (isEmpty(object.longitude)) {
            errors.push(ERROR_CODE.PROPERTY_ADDRESS_LONG_NOT_FOUND);
          }

          // if (isEmpty(object.documents) || object.documents.length === 0) {
          //   errors.push(ERROR_CODE.PROPERTY_ADDRESS_PROOF_NOT_FOUND);
          // }

          if (isEmpty(object.loanDocuments) || object.loanDocuments.length === 0) {
            errors.push(ERROR_CODE.PROPERTY_ADDRESS_PROOF_NOT_FOUND);
          }
          // if (object.loan?.product?.productType?.code === STATIC_MASTER_DATA.PRODUCT_NAME_LOAN_AGAINST_PROPERTY) {
          // }
        }
      }

      if (errors.length > 0) {
        this.logger.debug('Errors found in validating address ', errors.toString());
        throw new FunctionalException(errors);
      }
    }
  }

  async stageValidation(section: string, actionType: ActionType, object: LoanDTO, substage: string) {
    //let errors: string[] = [];
    let errors :Map<string, string[]> = new Map<string, string[]>();
    
    if (isEmpty(object)) {
      //errors.set(ERROR_CODE.STAGE_SOURCING_NOT_FOUND);
      let array_of_errors :string[]= errors.has("Extra_errors") ? errors.get("Extra_errors") : [];
      array_of_errors.push(ERROR_CODE.STAGE_SOURCING_NOT_FOUND);
      errors.set("Extra_errors",array_of_errors)
    } else {
      if (substage === LoginStage.DDE) {
        if (isEmpty(object.smChannelType)) {
          //errors.push(ERROR_CODE.STAGE_SOURCING_NOT_FOUND);
          let array_of_errors :string[]= errors.has("Extra_errors") ? errors.get("Extra_errors") : [];
          array_of_errors.push(ERROR_CODE.STAGE_SOURCING_NOT_FOUND);
          errors.set("Extra_errors",array_of_errors)
        }
        //errors.push(...(await this.isCompleteCollateralProperty(object)));
    const isCompCollProp = await this.isCompleteCollateralProperty(object);
    
    for (const [key, value] of isCompCollProp.entries()) {
        errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
    }

    const isCompRept=await this.isCompleteReceipt(object.uid)

    for (const [key, value] of isCompRept.entries()) {
      errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
    }
        //errors.push(...(await this.isCompleteReceipt(object.uid)));
    const isCompSaleStoryBoard=await this.isCompleteSalesStoryBoard(object.uid)
    
    for (const [key, value] of isCompSaleStoryBoard.entries()) {
      errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
    }
    //errors.push(...(await this.isCompleteSalesStoryBoard(object.uid)));
      }
    const isCompSectBySubstage=await this.isCompleteSectionsBySubstage(object.uid, substage)
    
    for (const [key, value] of isCompSectBySubstage.entries()) {
      errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
    }
      //errors.push(...(await this.isCompleteSectionsBySubstage(object.uid, substage)));

      if (errors.size > 0) {
        /* this.logger.debug('Errors found ', errors.toString());
        throw new FunctionalException(errors); */
        //console.log(errors);
        
      }
    }
  }

  async isCompleteSectionsBySubstage(loanUid: string, substage: string) {
    //let errors: string[] = [];
    let errors :Map<string, string[]> = new Map<string, string[]>();

    let applicantDTOs: ApplicantDTO[] = [];

    if (substage === LoginStage.QDE) {
      const applicants: [ApplicantDTO[], number] = await this.applicantService.search(
        0,
        1,
        {},
        {isActive: true, applicantType: APPLICANT_TYPE.PRIMARY, 'loan.uid': loanUid},
      );
      if (applicants[1] === 0) {
        errors.set("Extra_errors",[ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND]);
        //errors.push(ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND);
        return errors;
      }
      applicantDTOs.push(...applicants[0]);
    } else if (substage === LoginStage.DDE) {
      const [, totalApplicants] = await this.applicantService.search(0, 1, {}, {isActive: true, 'loan.uid': loanUid});
      [applicantDTOs] = await this.applicantService.search(
        0,
        totalApplicants,
        {},
        {isActive: true, 'loan.uid': loanUid},
      );
    }

    const refrenceDTOs: ApplicantDTO[] = applicantDTOs.filter(dto => dto.applicantType === APPLICANT_TYPE.REFERENCE);
    const directorDTOs: ApplicantDTO[] = applicantDTOs.filter(dto => dto.applicantType === APPLICANT_TYPE.DIRECTOR);

    for (const applicantDTO of applicantDTOs) {
      if (
        applicantDTO.applicantType !== APPLICANT_TYPE.REFERENCE &&
        applicantDTO.applicantType !== APPLICANT_TYPE.DIRECTOR
      ) {
        // errors.push(...(await this.isCompleteReferences(loanUid, applicantDTO)));
        // } else {
        if (
          applicantDTO.applicantType === APPLICANT_TYPE.CORPORATE_CO_APPLICANT ||
          applicantDTO.applicantType === APPLICANT_TYPE.CORPORATE_GUARANTOR
        ) {
          // validation required

          // is complete corporate basic info
          //errors.push(...this.isCompleteCorporateBasicInfo(applicantDTO));
          const isCompCorpBasicInfo = await this.isCompleteCorporateBasicInfo(applicantDTO);
          for (const [key, value] of isCompCorpBasicInfo.entries()) {
              errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
          }

          // is complete residential address
          //errors.push(...(await this.isCompleteResidentialAddress(applicantDTO, loanUid, ADDRESS_TYPE.CORPORATE)));
          const isCompResiAddr = await this.isCompleteResidentialAddress(applicantDTO, loanUid, ADDRESS_TYPE.CORPORATE)
          for (const [key, value] of isCompResiAddr.entries()) {
              errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
          }

          // is complete corporate mandatory documents
          // errors.push(...(await this.isCompleteCorporateMandatoryDocuments(loanUid, applicantDTO)));

          if (applicantDTO.applicantType === APPLICANT_TYPE.CORPORATE_CO_APPLICANT) {
            // is complete corporate other detail
            //errors.push(...(await this.isCompleteCorporateOtherDetail(applicantDTO)));
            const isCompCorpOtherDet = await this.isCompleteCorporateOtherDetail(applicantDTO)
            for (const [key, value] of isCompCorpOtherDet.entries()) {
                errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
            }

            // is complete director
            //errors.push(...(await this.isCompleteDirector(loanUid, applicantDTO, directorDTOs)));
            const isCompDir = await this.isCompleteDirector(loanUid, applicantDTO, directorDTOs)
            for (const [key, value] of isCompDir.entries()) {
                errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
            }

            // is complete bank acc
            //errors.push(...(await this.isCompleteBankAccountDetails(loanUid, applicantDTO)));
            const isCompBankAccDet = await this.isCompleteBankAccountDetails(loanUid, applicantDTO)
            for (const [key, value] of isCompBankAccDet.entries()) {
                errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
            }
          }
        } else {
          const isCompNameCont = await this.isCompleteNameContact(applicantDTO);
            for (const [key, value] of isCompNameCont.entries()) {
                errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
            }
          //errors.push(...this.isCompleteNameContact(applicantDTO));
          if (applicantDTO.applicantType !== APPLICANT_TYPE.DEPENDANT) {
            const isCompKYC = await this.isCompleteKYC(loanUid, applicantDTO, substage)
            for (const [key, value] of isCompKYC.entries()) {
                errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
            }
            //errors.push(...(await this.isCompleteKYC(loanUid, applicantDTO, substage)));
            const isCompResiAddr = await this.isCompleteResidentialAddress(applicantDTO, loanUid)
            for (const [key, value] of isCompResiAddr.entries()) {
                errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
            }
            //errors.push(...(await this.isCompleteResidentialAddress(applicantDTO, loanUid)));
          }
        }

        if (substage === LoginStage.DDE) {
          if (
            applicantDTO.applicantType === APPLICANT_TYPE.PRIMARY ||
            applicantDTO.applicantType === APPLICANT_TYPE.CO_APPLICANT
          ) {
            const isCompOtherDet = await this.isCompleteOtherDetail(loanUid, applicantDTO)
            for (const [key, value] of isCompOtherDet.entries()) {
                errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
            }
            //errors.push(...(await this.isCompleteOtherDetail(loanUid, applicantDTO)));
            const isCompRef = await this.isCompleteReferences(loanUid, applicantDTO, refrenceDTOs)
            for (const [key, value] of isCompRef.entries()) {
                errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
            }
            //errors.push(...(await this.isCompleteReferences(loanUid, applicantDTO, refrenceDTOs)));
            if (applicantDTO.applicantType === APPLICANT_TYPE.PRIMARY) {
              //errors.push(...(await this.isCompleteEmploymentDetails(loanUid, applicantDTO)));
              const isCompEmpDet = await this.isCompleteEmploymentDetails(loanUid, applicantDTO)
              for (const [key, value] of isCompEmpDet.entries()) {
                  errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
              }

              const isCompBankAccDet = await this.isCompleteBankAccountDetails(loanUid, applicantDTO)
              for (const [key, value] of isCompBankAccDet.entries()) {
                  errors.has(key)?errors.set(key, [...errors.get(key), ...value]):errors.set(key, value)
              }
              //errors.push(...(await this.isCompleteBankAccountDetails(loanUid, applicantDTO)));
            }
          }
        }
      }
    }

    return errors;
  }

  isCompleteNameContact(applicant: ApplicantDTO) {
    //let errors: string[] = [];
    let errors :Map<string, string[]> = new Map<string, string[]>();
    if (applicant.applicantType === APPLICANT_TYPE.PRIMARY) {
      if (isEmpty(applicant.dateOfBirth)) {
        errors.set(applicant?.applicantType,[ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND])
        //errors.push(ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND + ', ' + applicant?.applicantType);
      }
    } else {
      if (isEmpty(applicant.smRelationship)) {
        errors.set(applicant?.applicantType,[ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND])
        //errors.push(ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND + ', ' + applicant?.applicantType);
      }
    }

    return errors;
  }

  async isCompleteResidentialAddress(applicantDTO: ApplicantDTO, loanUid: string, addressType?: string) {
    //let errors: string[] = [];
    //let errors = {};
    let errors :Map<string, string[]> = new Map<string, string[]>();

    const addressDTO: AddressDTO = await this.basicInformationSectionService.findResidentialAddressByLoanUid(
      loanUid,
      applicantDTO.uid,
      addressType,
    );
      errors
    if (isEmpty(addressDTO) || isEmpty(addressDTO.pincode) || isEmpty(addressDTO.address)) {
      //errors.push(ERROR_CODE.RESIDENTIAL_ADDRESS_NOT_FOUND + ', ' + applicantDTO?.applicantType);
      errors.set(applicantDTO?.applicantType,[ERROR_CODE.RESIDENTIAL_ADDRESS_NOT_FOUND]);
    }

    return errors;
  }

  async isCompleteKYC(loanUid: string, applicantDTO: ApplicantDTO, substage: string) {
    //let errors: string[] = [];
    let errors :Map<string, string[]> = new Map<string, string[]>();

    if (
      substage === LoginStage.QDE ||
      (substage === LoginStage.DDE && applicantDTO.applicantType !== APPLICANT_TYPE.DEPENDANT)
    ) {
      const [, totalRec] = await this.kycService.search(
        0,
        1,
        {},
        {
          isActive: true,
          'loan.uid': loanUid,
          'applicant.uid': applicantDTO.uid,
        },
      );
      const [kycDTOs] = await this.kycService.search(
        0,
        totalRec,
        {},
        {
          isActive: true,
          'loan.uid': loanUid,
          'applicant.uid': applicantDTO.uid,
        },
      );

      let errorFlag: boolean = true;
      for (const kycDto of kycDTOs) {
        if (kycDto.docType.code === DOCUMENT_TYPE.PAN || kycDto.docType.code === DOCUMENT_TYPE.FORM_60) {
          errorFlag = false;
          break;
        }
      }

      if (errorFlag) {
        errors.set(applicantDTO?.applicantType,[ERROR_CODE.STAGE_KYC_NOT_FOUND])
        //errors.push(ERROR_CODE.STAGE_KYC_NOT_FOUND + ', ' + applicantDTO?.applicantType);
      }
    }

    return errors;
  }

  async isCompleteOtherDetail(loanUid: string, applicantDTO: ApplicantDTO) {
    //let errors: string[] = [];
    let errors :Map<string, string[]> = new Map<string, string[]>();

    if (
      isEmpty(applicantDTO.smMaritalStatus) ||
      isEmpty(applicantDTO.fatherOrSpouseName) ||
      isEmpty(applicantDTO.smEducation) ||
      isEmpty(applicantDTO.placeOfBirth)
    ) {
      errors.set(applicantDTO?.applicantType,[ERROR_CODE.OTHER_DETAIL_NOT_FOUND])
      //errors.push(ERROR_CODE.OTHER_DETAIL_NOT_FOUND + ', ' + applicantDTO?.applicantType);
    } else {
      const [permanentAddressDTO] = await this.addressService.search(
        0,
        1,
        {},
        {
          'applicant.uid': applicantDTO.uid,
          'loan.uid': loanUid,
          primaryAddressType: ADDRESS_TYPE.PERMANENT,
        },
      );

      if (isEmpty(permanentAddressDTO) || permanentAddressDTO.length === 0 || isEmpty(permanentAddressDTO[0].address)) {
        errors.set(applicantDTO?.applicantType,[ERROR_CODE.OTHER_DETAIL_NOT_FOUND])
        //errors.push(ERROR_CODE.OTHER_DETAIL_NOT_FOUND + ', ' + applicantDTO?.applicantType);
      }
    }

    return errors;
  }

  async isCompleteEmploymentDetails(loanUid: string, applicantDTO: ApplicantDTO) {
    let errors :Map<string, string[]> = new Map<string, string[]>();
    const [, count] = await this.employmentDetailService.search(
      0,
      1,
      {},
      {'loan.uid': loanUid, 'applicant.uid': applicantDTO.uid, isActive: true},
    );

    /* if (count === 0) {
      return [ERROR_CODE.EMPLOYMENT_DETAIL_NOT_FOUND + ', ' + applicantDTO.applicantType];
    } else {
      return [];
    } */
    return count===0?errors.set(applicantDTO.applicantType,[ERROR_CODE.EMPLOYMENT_DETAIL_NOT_FOUND]):errors
  }

  async isCompleteBankAccountDetails(loanUid: string, applicantDTO: ApplicantDTO) {
    const [, count] = await this.bankingDetailService.search(
      0,
      1,
      {},
      {'loan.uid': loanUid, 'applicant.uid': applicantDTO.uid, isActive: true},
    );
    let errors :Map<string, string[]> = new Map<string, string[]>();
    /* if (count === 0) {
      errors.set(applicantDTO.applicantType,[ERROR_CODE.BANK_ACCOUNT_DETAIL_NOT_FOUND])
      return errors;
      //return [ERROR_CODE.BANK_ACCOUNT_DETAIL_NOT_FOUND + ', ' + applicantDTO.applicantType];
    } else {
      return errors;
    } */
    return count === 0?errors.set(applicantDTO.applicantType,[ERROR_CODE.BANK_ACCOUNT_DETAIL_NOT_FOUND]):errors
  }

  async isCompleteReferences(loanUid: string, applicantDTO: ApplicantDTO, refrenceDTOs: ApplicantDTO[]) {
    let errors :Map<string, string[]> = new Map<string, string[]>();
    if (isEmpty(refrenceDTOs) || refrenceDTOs.length === 0) {
      errors.set("Extra_errors",[ERROR_CODE.REFERENCES_NOT_FOUND])
      //return [ERROR_CODE.REFERENCES_NOT_FOUND];
    }
    // const [, count] = await this.applicantService.search(
    //   0,
    //   1,
    //   {},
    //   {
    //     'loan.uid': loanUid,
    //     'parent.uid': applicantDTO.parent.uid,
    //     'applicantType': APPLICANT_TYPE.REFERENCE,
    //     isActive: true,
    //   },
    // );

    const filteredRefrences: ApplicantDTO[] = refrenceDTOs.filter(
      dto => dto.parent?.uid === applicantDTO.uid && dto.isActive,
    );

    if (filteredRefrences.length < 2) {
      let array_of_errors :string[]= errors.has(applicantDTO.applicantType) ? errors.get(applicantDTO.applicantType) : [];
      array_of_errors.push(ERROR_CODE.REFERENCES_NOT_FOUND);
      errors.set(applicantDTO.applicantType,array_of_errors)
      return errors;
      //return [ERROR_CODE.REFERENCES_NOT_FOUND + ', ' + applicantDTO.applicantType];
    } else {
      return errors;
    }
  }

  async isCompleteCollateralProperty(loanDTO: LoanDTO) {
    //let errors: string[] = [];
    let errors :Map<string, string[]> = new Map<string, string[]>();
    // if (loanDTO?.product?.productType?.code === STATIC_MASTER_DATA.PRODUCT_NAME_LOAN_AGAINST_PROPERTY) {
    let [, toatalRecords] = await this.addressService.search(
      0,
      1,
      {},
      {
        'loan.uid': loanDTO.uid,
        primaryAddressType: ADDRESS_TYPE.COLLATERAL_PROPERTY,
        isActive: true,
      },
    );

    if (toatalRecords === 0) {
      let array_of_errors :string[]= errors.has("Extra_errors") ? errors.get("Extra_errors") : [];
      array_of_errors.push(ERROR_CODE.COLLATERAL_PROPERTY_NOT_FOUND);
      errors.set("Extra_errors",array_of_errors)
      //errors.push(ERROR_CODE.COLLATERAL_PROPERTY_NOT_FOUND);
    }
    // }
    return errors;
  }

  async isCompleteReceipt(loanUid: string) {
    const [, totalRecords] = await this.receiptService.search(0, 1, {}, {isActive: true, 'loan.uid': loanUid});
    let errors :Map<string, string[]> = new Map<string, string[]>();
    //return [ERROR_CODE.RECEIPT_NOT_FOUND];
    return totalRecords === 0 ? errors.set("Extra_errors", [ERROR_CODE.RECEIPT_NOT_FOUND]) : errors;

  }

  async corporateBasicInfo(section: string, actionType: ActionType, object: ApplicantDTO, subStage?: string) {
    let errors: string[] = [];

    if (isEmpty(object.firstName)) {
      errors.push(ERROR_CODE.CORPORATE_NAME_NOT_FOUND);
    }

    if (isEmpty(object.smBusinessConstitution)) {
      errors.push(ERROR_CODE.CORPORATE_BUSINESS_CONSTITUTION_NOT_FOUND);
    }

    if (isEmpty(object.employmentRegistrationNo)) {
      errors.push(ERROR_CODE.CORPORATE_EMP_REG_NOT_FOUND);
    }

    if (isEmpty(object.incorporationDate)) {
      errors.push(ERROR_CODE.CORPORATE_INCORPORATION_DATE_NOT_FOUND);
    }

    if (isEmpty(object.loanDocuments) || object.loanDocuments.length === 0) {
      errors.push(ERROR_CODE.CORPORATE_BUSINESS_PROOF_NOT_FOUND);
    }

    if (isNotEmpty(object.applicantType)) {
      if (object.applicantType === APPLICANT_TYPE.CORPORATE_CO_APPLICANT) {
        // if (isEmpty(object.udyamRegistrationCertNo)) {
        //   errors.push(ERROR_CODE.CORPORATE_UDYAM_CERT_NOT_FOUND);
        // }

        if (isEmpty(object.smSegment)) {
          errors.push(ERROR_CODE.CORPORATE_SEGMENT_NOT_FOUND);
        }

        if (isEmpty(object.smNoOfEmployee)) {
          errors.push(ERROR_CODE.CORPORATE_NO_OF_EMPLOYEE_NOT_FOUND);
        }

        if (isEmpty(object.smBusinessPremisesOwnership)) {
          errors.push(ERROR_CODE.CORPORATE_BUSINESS_PREMISES_OWNERSHIP_NOT_FOUND);
        }

        if (isEmpty(object.totalExpInYears)) {
          errors.push(ERROR_CODE.CORPORATE_TOTAL_EXP_YEARS_NOT_FOUND);
        }

        if (isEmpty(object.businessEstGrossMargin)) {
          errors.push(ERROR_CODE.CORPORATE_EST_GROSS_MARGIN_NOT_FOUND);
        }

        if (isEmpty(object.businessEstNetMargin)) {
          errors.push(ERROR_CODE.CORPORATE_NET_MARGIN_NOT_FOUND);
        }

        if (isEmpty(object.businessYearsInCurrentLocation)) {
          errors.push(ERROR_CODE.CORPORATE_YEAR_CURRENT_LOC_NOT_FOUND);
        }
      }
    }

    if (errors.length > 0) {
      this.logger.debug('Errors found in validating Basic Information ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async corporateAddress(section: string, actionType: ActionType, object: AddressDTO, subStage?: string) {
    let errors: string[] = [];

    if (isEmpty(object.applicant) || isEmpty(object.applicant.uid)) {
      errors.push(ERROR_CODE.APPLICANT_NOT_FOUND);
    }

    if (isEmpty(object.address)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_NOT_FOUND);
    }

    if (isEmpty(object.pincode)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_PINCODE_NOT_FOUND);
    }

    if (isEmpty(object.city)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_CITY_NOT_FOUND);
    }

    if (isEmpty(object.latitude)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_LAT_NOT_FOUND);
    }

    if (isEmpty(object.longitude)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_LONG_NOT_FOUND);
    }

    if (isEmpty(object.isSameAsRegisteredGstAddress)) {
      errors.push('checkbox value cannot be null');
    }

    // if (isEmpty(object.documents) || object.documents.length === 0) {
    //   errors.push(ERROR_CODE.PROPERTY_ADDRESS_PROOF_NOT_FOUND);
    // }

    // if (object.applicant?.applicantType === APPLICANT_TYPE.CORPORATE_GUARANTOR) {
    //   if (isEmpty(object.loanDocuments) || object.loanDocuments.length === 0) {
    //     errors.push(ERROR_CODE.PROPERTY_ADDRESS_PROOF_NOT_FOUND);
    //   }
    // }

    if (errors.length > 0) {
      this.logger.debug('Errors found in validating corporate address ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async corporateOtherDetail(section: string, actionType: ActionType, object: ApplicantDTO, subStage?: string) {
    let errors: string[] = [];

    if (isEmpty(object.businessModelDetailedWriteup)) {
      errors.push(ERROR_CODE.CORPORATE_OTHER_WRITEUP_NOT_FOUND);
    }

    if (errors.length > 0) {
      this.logger.debug('Errors found in validating corporate other detail ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  async corporateDirector(section: string, actionType: ActionType, object: AddressDTO, subStage?: string) {
    let errors: string[] = [];

    if (isEmpty(object.applicant)) {
      errors.push(ERROR_CODE.APPLICANT_NOT_FOUND);
    }

    if (isEmpty(object.applicant.firstName)) {
      errors.push(ERROR_CODE.APPLICANT_FIRST_NAME_NOT_FOUND);
    }

    if (isEmpty(object.applicant.smRelationship)) {
      errors.push(ERROR_CODE.RELATIONSHIP_REUIRED);
    }

    if (isEmpty(object.applicant.dateOfBirth)) {
      errors.push(ERROR_CODE.APPLICANT_DOB_NOT_FOUND);
    }

    // if (isEmpty(object.applicant.aadhar)) {
    //   errors.push(ERROR_CODE.AADHAR_NOT_FOUND);
    // }

    // if (isEmpty(object.applicant.pan)) {
    //   errors.push(ERROR_CODE.PAN_NOT_FOUND);
    // }

    if (isEmpty(object.applicant.mobileNo)) {
      errors.push(ERROR_CODE.APPLICANT_MOBILE_NOT_FOUND);
    }

    if (isEmpty(object.address)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_NOT_FOUND);
    }

    if (isEmpty(object.pincode)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_PINCODE_NOT_FOUND);
    }

    if (isEmpty(object.city)) {
      errors.push(ERROR_CODE.PROPERTY_ADDRESS_CITY_NOT_FOUND);
    }

    if (errors.length > 0) {
      this.logger.debug('Errors found in validating corporate director ', errors.toString());
      throw new FunctionalException(errors);
    }
  }

  isCompleteCorporateBasicInfo(applicantDTO: ApplicantDTO) :Map<string, string[]> {
    let errors :Map<string, string[]> = new Map<string, string[]>();
    
    return (isEmpty(applicantDTO.smBusinessConstitution) || isEmpty(applicantDTO.incorporationDate))  ? errors.set(applicantDTO?.applicantType, [ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND]) : errors;
    /* if (isEmpty(applicantDTO.smBusinessConstitution) || isEmpty(applicantDTO.incorporationDate)) {
      return [ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND + ', ' + applicantDTO?.applicantType];
    }
    return []; */
  }

  isCompleteCorporateOtherDetail(applicantDTO: ApplicantDTO): Map<string, string[]>  {
    /* if (isEmpty(applicantDTO.businessModelDetailedWriteup)) {
      return [ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND + ', ' + applicantDTO?.applicantType];
    }
    return []; */
    let errors :Map<string, string[]> = new Map<string, string[]>();

    return isEmpty(applicantDTO.businessModelDetailedWriteup)?errors.set(applicantDTO?.applicantType,[ERROR_CODE.STAGE_NAME_CONTACT_NOT_FOUND]):errors
  }

  async isCompleteDirector(loanUid: string, applicantDTO: ApplicantDTO, directorDTOs: ApplicantDTO[]) {
    let errors :Map<string, string[]> = new Map<string, string[]>();

    if (isEmpty(directorDTOs) || directorDTOs.length === 0) {
      errors.set(applicantDTO.applicantType,[ERROR_CODE.STAGE_CORPORATE_DIRECTOR_NOT_FOUND])
      return errors;
      //return [ERROR_CODE.STAGE_CORPORATE_DIRECTOR_NOT_FOUND + ', ' + applicantDTO.applicantType];
    }

    

    const filteredDirectors: ApplicantDTO[] = directorDTOs.filter(
      dto => dto.parent?.uid === applicantDTO.uid && dto.isActive,
    );

    if (filteredDirectors.length < 1) {
      errors.set(applicantDTO.applicantType,[ERROR_CODE.STAGE_CORPORATE_DIRECTOR_NOT_FOUND])
      return errors;
      //return [ERROR_CODE.STAGE_CORPORATE_DIRECTOR_NOT_FOUND + ', ' + applicantDTO.applicantType];
    } else {
      return errors;
    }
  }

  async isCompleteCorporateMandatoryDocuments(loanUid: string, applicantDTO: ApplicantDTO) {
    let errors: string[] = [];

    const [, totalRec] = await this.kycService.search(
      0,
      1,
      {},
      {
        isActive: true,
        'loan.uid': loanUid,
        'applicant.uid': applicantDTO.uid,
      },
    );
    const [kycDTOs] = await this.kycService.search(
      0,
      totalRec,
      {},
      {
        isActive: true,
        'loan.uid': loanUid,
        'applicant.uid': applicantDTO.uid,
      },
    );

    let isPanFound: boolean = false;
    let isTanFound: boolean = false;

    for (const kycDto of kycDTOs) {
      if (kycDto.docType.code === DOCUMENT_TYPE.PAN) {
        isPanFound = true;
      }
      // if (kycDto.docType.code === DOCUMENT_TYPE.TAN) {
      isTanFound = true;
      // }

      if (isPanFound && isTanFound) {
        return errors;
      }
    }

    if (!(isPanFound && isTanFound)) {
      errors.push(ERROR_CODE.STAGE_CORPORATE_MANDATORY_DOC_NOT_FOUND + ', ' + applicantDTO?.applicantType);
    }

    return errors;
  }

  async isCompleteSalesStoryBoard(loanUid: string) {
    const [, count] = await this.stageStoryboardRecomendationService.search(
      0,
      1,
      {},
      {
        'loan.uid': loanUid,
        smSectionType: StoryBoard.SALES_STORY_BOARD,
        isActive: true,
      },
    );
    let errors :Map<string, string[]> = new Map<string, string[]>();
    
    return count === 0 ? errors.set("Extra_errors", [ERROR_CODE.RECEIPT_NOT_FOUND]) : errors;
    /* if (count === 0) {
      return [ERROR_CODE.STORY_BOARD];
    } else {
      return [];
    } */
  }
}
