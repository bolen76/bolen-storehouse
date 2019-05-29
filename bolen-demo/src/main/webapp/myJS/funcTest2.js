var name="The window";
object={
	name:"My Object",
	getName:function () {
		return this.name;
	  
	}
	
};
(object.func=object.getName);
var result=object.func();
debugger;
alert(result);

