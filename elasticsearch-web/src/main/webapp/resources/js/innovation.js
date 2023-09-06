
function goHomePage(){
	 window.location.href='/home';
};
function goRegisterPage(){
	 window.location.href='/register';
};
function goSuccessPage(){
	 window.location.href='/success';
};

function callSearhByProjectService(data){
	  $.ajax({
		     type: "POST",
		     contentType: "application/json",
		     url: '/search',
		     dataType: 'json',
		     data: JSON.stringify(data),
		     success: function(responce) {
		    	 $.each( responce,function(key, bean) {
		             var htmlrow ="<tr class='dataRow'><td>" + bean.id + 
		             "</td><td>"+bean.projectName +
		             "</td><td>"+bean.submitterEmail+
		             "</td><td>"+bean.petented+
		             "</td><td>"+bean.projectLink+
		             "</td><td>"+bean.submittedDate+
		             "</td><td>"+bean.summaryDetails+
		             "</td></tr>";         
		             $('.result').append(htmlrow);
		         });
		    	 
		    	
		    	 
		     }
		});
}






