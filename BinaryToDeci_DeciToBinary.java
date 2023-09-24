int bin=1;
        int places=0;
        int deci=0;
        while(bin!=0){
            int curr=bin%10;
            deci+=(curr*Math.pow(2,places));
            places++;
            bin=bin/10;
        }
        System.out.println(deci);
        int deci=49;
        int places=1;
        int bin=0;
        while(deci!=0){
            int curr=deci%2;
            bin=(curr*places)+bin;
            places*=10;
            deci/=2;
        }
        System.out.println(bin);