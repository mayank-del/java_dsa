async function f(){
    return "hello world!"
}
console.log(f())

f().then(res=>{
    console.log(res);
})