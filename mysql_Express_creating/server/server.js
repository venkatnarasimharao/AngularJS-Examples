var express=require("express");
var mysql=require("mysql");

//create the rest object
var app=express();
app.use(express.static(__dirname+"/../../mysql"));

//create the connection object
var connection=mysql.createConnection({
    host:"localhost",
    user:"root",
    password:"root",
    database:"ng6am"
});
//connection to database
connection.connect();

//create the restApi
app.get("/products",function(req,res){
    connection.query("select * from products",
    function(err,recordsArray,fields){
        res.send(recordsArray,err,fields);
    
    });
});
app.listen(8082);
console.log('server is listening port no 8082');