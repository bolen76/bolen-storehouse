var array=new Array();
array.push("hello");
array.push(3);
array.forEach(function(item,index,array){
	debugger;
	item+=item;
	
});
alert(array);