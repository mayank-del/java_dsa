//const p=require("queue");
https://sahayya.dev.vm.web-devapp.com/custom/api/black/list

/* ere's an overview of how Map works:

Creating a Map:
You can create a new Map object using the new keyword:

javascript
Copy code
let myMap = new Map();
Adding Entries:
You can add entries to a Map using the set() method:

javascript
Copy code
myMap.set(key, value);
Getting Values:
You can retrieve values from a Map using the get() method:

javascript
Copy code
myMap.get(key);
Checking for Key Existence:
You can check if a key exists in a Map using the has() method:

javascript
Copy code
myMap.has(key);
Deleting Entries:
You can delete entries from a Map using the delete() method:

javascript
Copy code
myMap.delete(key);
Iterating over Entries:
You can iterate over the entries of a Map using various methods such as forEach(), for...of loop, or entries() method:

javascript
Copy code
// Using forEach()
myMap.forEach((value, key) => {
    console.log(key + ' = ' + value);
});

// Using for...of loop
for (let [key, value] of myMap) {
    console.log(key + ' = ' + value);
}
 */

/* function createMap() {
    let map = new Map();
    map.set(1, "ram");
    map.set(2, "shyam");
    console.log(map);
}
createMap() */
var map = new Map();
function createMap(key,val) {
    
    if(map.has(key)){
        let arr=map.get(key)
        arr.push(val);
        map.set(key,arr);
    }else{
        let arr=[]
        arr.push(val);
        map.set(key,arr)
    }
 
    
}
createMap("one","flana")
createMap("one","dimkahan")
createMap("one","bol_jana")
createMap("two","jana_kaha")
createMap("two","ludhakna")

var map2=new Map();

map2.set("one",["rawna"]);
map2.set("one",["diwana"])
map2.set("two",["rozana"])
for(const [key,value] of map2.entries()){
    map.has(key)?map.set(key,[...map.get(key),...value]):map.set(key,value)

}

console.log(map);

const b=[2,4,67,0]
b.sort();
console.log(b);





