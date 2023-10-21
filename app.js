const data={"name":{"first":"Robert","middle":"","last":"Smith"},"age":25,"DOB":"-","hobbies":["running","coding","-"],"education":{"highschool":"N\/A","college":"Yale"}}


let cnt=0
    let d=data
    const vals=["N/A","","-"]
    function rem(obj,vals){
      for(const key in obj){
        if(typeof obj[key]==="object"){
          rem(obj[key],vals);
        }else{
          if(vals.includes(obj[key])){
            delete obj[key]
            cnt++;
          }
        }
      }
    }
  
    rem(d,vals)
    d["items_removed"]=cnt
    
    console.log(d);