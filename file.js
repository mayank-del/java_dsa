const http=require("http");

const fs=require("fs");

const options={
    hostname:"localhost",
    port:4000,
    path:"/read",
    method:"GET"
}
/* const server=http.createServer();
server.on("request",(req,res)=>{
    fs.readFile("mike.txt",(err,data)=>{
        if(err) return console.log(err);

        res.end(data.toString());
    });
})
 */

const server=http.createServer((req,res)=>{
    /* fs.readFile("mike.txt",(err,data)=>{
        res.end(data)
    }) */

    const stream=fs.createReadStream("mike.txt")
    stream.pipe(res)


})

server.listen(3000,"localhost")