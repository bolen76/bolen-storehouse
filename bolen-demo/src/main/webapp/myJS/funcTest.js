window.color="red";
var obj={color:"blue"};

function sayColor(){
	alert(this.color);
}

var objSayColor=sayColor.bind(obj);
debugger;
objSayColor();
sayColor();

function Person(){
	
}

var person=new Person();
alert(person instanceof Person);
person.constructor=Object;
var test=person instanceof Person;
alert(person instanceof Person);
