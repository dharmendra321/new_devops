function openNav() {
    document.getElementById("mySidenav").style.width = "70%";
    // document.getElementById("flipkart-navbar").style.width = "50%";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.body.style.backgroundColor = "rgba(0,0,0,0)";
}
$(document).ready(function() {
	$(".btn-pref .btn").click(function () {
	    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
	    $(this).removeClass("btn-default").addClass("btn-primary");   
	});
	
		console.log("message.."+type);
			
	
});

//var data1=[['1','ABC'],['2','ABCD'],['4','ABCDDDD']];
var category=window.category;
var dataurl="";
if(category==0)
	 dataurl=window.contextroot+"/data/json/product/all";
else
	dataurl=window.contextroot+"/data/json/product/"+category;
$mytable=$("#productlist");
$mytable.DataTable({
	//data:data1
	ajax:{
			//url:"http://localhost:8080/onlinefrontend/data/json/product/all",
		url:dataurl,
		dataSrc:''
		},
		columns:[
				{
				data: 'pid',
				mRender:function(data){
					return"<img height='100' width='100' src='"+window.contextroot+"/resources/images/product/"+data+".jpg'/>"
				}
				},
				{
					data: 'productName'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitprice',
					mRender: function(data)
					{
						return '&#8377;'+data
					}
				 },
				{
					data: 'pid',
					bSortable:false,
					mRender:function(data){
						return"<a href='show/"+data+"' class='btn btn-info'><span class='glyphicon glyphicon-eye-open '></span></a>"
					}
				}
				]
	});