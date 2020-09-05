$(function()
{
	//-----------------------------------
	//solving the active menu problem
	//-------------------------------------
	
	switch(menu)
	{
		case 'About' :
		     $('#about').addClass('active');
		     break;
	    case 'Contact' :
		     $('#contact').addClass('active');
		     break;
        case 'AllProducts' :
		     $('#listProducts').addClass('active');
		     break;
        case 'ManageProducts' :
		     $('#manageProducts').addClass('active');
		     break;
      case 'UserCart' :
		     $('#cart').addClass('active');
		     break;
        case 'Home' :
		     $('#home').addClass('active');
		     break;

       
	    default :
             if(menu == "Home") break;
		     $('#listProducts').addClass('active');
              $('#a_'+menu).addClass('active');
		     break;
	}
//-------------------------------------------------------------

	
//-------------------------------------------------------------------------
// product show customer datatable code
//---------------------------------------------------

	
	var $table = $('#productListTable');
	
	
	
   if($table.length){
	
	
	var jsonUrl = '';
	
	if( window.categoryId == '')
	{
		
		jsonUrl = window.contextRoot + '/json/data/all/products';
		console.log('url null');
		console.log('url null'+window.contextRoot);
		
	}
	else
	{
		
		jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		console.log('url '+ window.categoryId);
	}
	
	
	
	
	
	$table.DataTable(
		{
			
			lengthMenu : [[3,5,10,-1],['3','5','10','All']],
			
			pageLength : 5,
			
			
 ajax : {
		url : jsonUrl,
		
		dataSrc : ''
		
		
		
	},
	
	columns : [
		
		{
			data : 'code',
			mRender : function(data,type,row){
				
				return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg  " class="dataTableImg"   />'
			}
		},
		{
			
			
			data : 'name' 
		},
		{
			
			data : 'unitPrice',
			mRender: function(data,type,row)
			{
				
				return '&#8377;  '+data
			}
		},
		{
			
			data : 'quantity',
			mRender:function(data,type,row)
			{
				if(data<1)
				{
					
					return '<span class="color:red">Out of Stock!</span>'
					
				}
				else
				{
					
					return data;
				}
				
			},
			
			
		},
		{
			
			data : 'id',
			bSortable: false,
			mRender : function(data,type,row)
			{
				
				var str='';
				str+='<a href="'+window.contextRoot+'/show/'+data+'/product"  class="btn btn-primary"><i class="fa fa-eye-open"></i>View</a> ' 
				
				
				if(window.userRole == 'ADMIN')
				{
					
					str+='<a href="'+window.contextRoot+'/manage/'+data+'/product"class="btn btn-success"><i class="fa fa-shopping-cart">Edit</a>' ;
			
					
					
				}
				else
				{
				
				
				
				if(row.quantity<1)
				{
						
				str+='<a href="javascript:void(0)"class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span><strike>Add to cart</strike></a>' ;
				
					
				}
				else
				{
						
				str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product"class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>' ;
			
					
				}
				
				}
				return str;
				
			}
			
		},
		
	]
	
			
		});
	
	
}
//-----------------------------------------------------------------------------------------------------------



//-----------------------------------
//dismissing the alert after 3 second
//-----------------------------------

var $alert = $('.alert');

if($alert.length)
{
	
	setTimeout(function(){
		
		
		$alert.fadeOut('slow');
		
		},3000)
		
		
	
	
}




//--------------------------------------------------------------




//--------------------------------------------------------------------
// admin table data
//-----------------------------------------------------------------------



var $adminProductsTables = $('#adminProductsTables');
	
	
	
   if($adminProductsTables.length){
	
	
	var jsonUrl = window.contextRoot+'/json/data/admin/all/products';
	
	
	
	
	
	
	$adminProductsTables.DataTable(
		{
			
			lengthMenu : [[10,30,50,-1],['10','30','50','All']],
			
			pageLength : 30,
			
			
 ajax : {
		url : jsonUrl,
		
		dataSrc : ''
		
		
		
	},
	
	columns : [
		
		{
			
			
			data:'id'
			
			
		},
		
		{
			data : 'code',
			mRender : function(data,type,row){
				
				return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg " class="adminDataTableImg"   />'
			}
		},
		
		{
			
			
			data : 'brand' 
		},
		{
			
			
			data : 'name' 
		},
		
			{
			
			data : 'quantity',
			mRender:function(data,type,row)
			{
				if(data<1)
				{
					
					return '<span class="color:red">Out of Stock!</span>'
					
				}
				else
				{
					
					return data;
				}
				
			},
			
			
		},
		{
			
			data : 'unitPrice',
			mRender: function(data,type,row)
			{
				
				return '&#8377;  '+data
			}
		},
	
		{
			
			data : 'active',
			bSortable: false,
			mRender : function(data,type,row)
			{
				
				var str='';
				
				str+='<label class="switch"> ';
				
				if(data)
				{
					
					str+='<input  type="checkbox" checked="checked" value="'+row.id+'"     />';
				}
				else
				{
					
					str+='<input  type="checkbox"  value="'+row.id+'"     />';
				}
				
			
			    str+=	'<div class="slider"></div></label>';
				
				return str;
		}
		
		},
		
		
		
		{
			
			data : 'id',
			bSortable: false,
			mRender : function(data,type,row)
			{
				
				var str='';
				
				str+='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-primary">Edit</a> ';
				
		
				
				return str;
		     }
		
		},
		
		
	],
	
	//------------------------------------------------
	// code for toggle button and model popup box js
	//------------------------------------------------
	
	initComplete:function(){
		
		var api = this.api();
		
		api.$('.switch input[type="checkbox"]').on('change',function(){
	
	var checkbox = $(this);
	var checked    = checkbox.prop('checked');
	var dMsg = (checked)? 'you want to activate the product':'you want to deactivate the product?';
	
	var value = checkbox.prop('value');
	
	
	bootbox.confirm({
		
		size:'medium',
		title:'product activation and deactivation',
		message: dMsg,
		
		callback: function(confirmed){
			
			if(confirmed)
			{
				
				
				var activationUrl = window.contextRoot + '/manage/product/'+value+'/activation';
				$.post(activationUrl,function(data){
					
					
					bootbox.alert({
					
					size:'medium',
					title:'information',
					message:data
					          });
					
					
					
				});
				
				
				
				
				
			}
			else
			{
				
				
				checkbox.prop('checked',!checked);
			}
			
				
		}
			
	});
	
});

//------------------------------------------------------------------------------------------

		
		
		
		
	}
	
	
	
	
			
		});
	
	
}









//-----------------------------------------------------------------------------

//---------------------------------------------------------------------
// Category Form validation in add category Modal
//----------------------------------------------------------------------

 var $categoryForm = $('#categoryForm');

if($categoryForm.length)
{
	
	$categoryForm.validate({
		
		
		rules : {
			
			
			name : {
				
				
				required : true,
				minlength : 2
			},
			
			description : {
				
				required : true,
				
			}
		},
		
		messages : {
			
			
			name :{
				
				
				required : 'please add the category name',
				minlength : 'the category name should not be less than 2 character'
				
				},
			
			description:{
				
				
				
				required : 'please add a description for the category'
				
			}
			
			
		},
		
		errorElement:'em',
		
		errorPlacement:function(error,element)
		{
			
			error.addClass('help-block');
			error.insertAfter(element);
			
		}
		
		
	});
	
	
	
}






//---------------------------------------------------------------------
// Login Form validation 
//----------------------------------------------------------------------

 var $loginForm = $('#loginForm');

if($loginForm.length)
{
	
	$loginForm.validate({
		
		
		rules : {
			
			
			username : {
				
				
				required : true,
				email : true
			},
			
			password : {
				
				required : true,
				
			}
		},
		
		messages : {
			
			
			username :{
				
				
				required : 'please Enter the username',
				email : 'please enter the valid email address'
				
				},
			
			password :{
				
				
				
				required : 'please enter the password'
				
			}
			
			
		},
		
		errorElement:'em',
		
		errorPlacement:function(error,element)
		{
			
			error.addClass('help-block1');
		  error.insertAfter(element);
			
		}
		
		
	});
	
	
	
}



$('button[name="refreshCart"]').click(function(){
	
	
	var cartLineId = $(this).attr('value');
	
	var countElement = $('#count_'+cartLineId);
	
	
	var originalCount = countElement.attr('value');
	
	var currentCount = countElement.val();
	
	
	
	if(currentCount!== originalCount )
	{
		
		if(currentCount < 1 || currentCount > 3)
		{
			
			countElement.val(originalCount);
			
			bootbox.alert({
				
				
				
				size : 'medium',
				title : 'Error',
				message : 'product count should be minimum 1 and miximum 3!'
				
			});
			
		}
		else
		{
			
			
			var updatecart = window.contextRoot +'/cart/'+cartLineId+'/update?count='+currentCount;
			
			window.location.href=updatecart;
			
			
		}
		
	}
	
	
	
});



// scrollBanner
	function scrollBanner(config) {
		scrollPos = $(this).scrollTop();
		config.bannerText.css({
			'margin-top' : -(scrollPos/3) + "px",
			'opacity' : 1-(scrollPos/300)
		});
		config.banner.css({
			'background-position': 'center ' + (-scrollPos/4) + "px"
		});
	}
	$(document).ready(function(){
		$(window).scroll(function() {
			scrollBanner({
				banner: $('.banner'),
				bannerText: $('.banner-text')
			});
		});
	});
	
	
	
	//contact validation
	
	


 var $contactForm = $('#contactForm');

if($contactForm.length)
{
	
	$contactForm.validate({
		
		
		rules : {
			
			
			name : {
				
				
				required : true,
				
			},
			
			email : {
				
				required : true,
				email : true
				
			},
			message : {
				
				required : true,
				
			}
		},
		
		messages : {
			
			
			name :{
				
				
				required : 'please Enter the rname',
				
				
				},
			
			email :{
				
				
				
				required : 'please enter the email',
				email : 'please enter the valid email address'
				
			},
			messgae :{
				
				
				required : 'please write the message'
			}
			
			
		},
		
		errorElement:'em',
		
		errorPlacement:function(error,element)
		{
			
			error.addClass('help-block1');
		  error.insertAfter(element);
			
		}
		
		
	});
	
	
	
}




});








// some scripts

// jquery ready start
$(document).ready(function() {
	// jQuery code



    
    /* ///////////////////////////////////////

    THESE FOLLOWING SCRIPTS ONLY FOR BASIC USAGE, 
    For sliders, interactions and other

    */ ///////////////////////////////////////
    

	//////////////////////// Prevent closing from click inside dropdown
    $(document).on('click', '.dropdown-menu', function (e) {
      e.stopPropagation();
    });


    

	//////////////////////// Bootstrap tooltip
	if($('[data-toggle="tooltip"]').length>0) {  // check if element exists
		$('[data-toggle="tooltip"]').tooltip()
	} // end if




    
}); 
// jquery end