function name(name,value) {
	alert(name+"heloo"+value);
	
	alert(arguments.length);
	alert(arguments[2]);
}
name("world ", "java",100);
debugger
function test(num1,num2){
  	
	var n1=Number(num1);
	var n2=num2;
	var n3=n1+n2;
	alert(n3);
}

test("100",200);

