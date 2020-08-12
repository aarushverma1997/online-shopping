$(function()
{
	//solving the active menu problem
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

       
	    default :
             if(menu == "Home") break;
		     $('#listProducts').addClass('active');
              $('#a_'+menu).addClass('active');
		     break;
	}
	
	
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
			date : 'code',
			mRender : function(data,type,row){
				
				return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jsp  " class="dataTableImg"   />'
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
				str+='<a href="'+window.contextRoot+'/show/'+data+'/product"  class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span>View</a> &#160' 
				
				
				if(row.quantity<1)
				{
						
				str+='<a href="javascript:void(0)"class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span><strike>Add to cart</strike></a>' ;
				
					
				}
				else
				{
						
				str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product"class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>' ;
			
					
				}
				return str;
				
			}
			
		},
		
	]
	
			
		});
	
	
}
});