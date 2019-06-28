$(document).ready(function(){
		$('#container').hide();
		var urlBase = "http://localhost:8080/";
		loadEndUsers();
		loadComments();
	$("#loginUser").click(function(){
			 formData = JSON.stringify({
					userEmail: $("#inputFormLogin [name='email']").val(),
					userPassword: $("#inputFormLogin [name='password']").val()
					
				 });
			 
				$.ajax({
					method : 'POST',
					url : urlBase + "user/loginA",
					data: formData,
					contentType: "application/json",
					datatype: "json",
					success : function(data){

						sessionStorage.setItem('loggedId',data.userId);
						console.log(data.userType);
						if(data.userType==='ADMIN'){
							$('#container').show();
							 $('#inputModal').modal('toggle');
						}else{
							window.location.href='/';
						}
						
					
					},
					error : function(error) {
						alert("Neispravni email i sifra ");
					}
				});
			
		});

		$("#register").click(function(){

			 formData = JSON.stringify({
				 userUsername : $("#usernameReg").val(),
				 userFirstName: $("#nameReg").val(),
				 userLastName: $("#lastnameReg").val(),
				 userAddress:$("#address").val(),
				 userBusinessName : $("#businessName").val(),
				 userBusinessId : $("#userBusinessId").val(),
				 userEmail : $("#emailReg").val(),
			 	userPassword : $("#passwordReg").val()
			});
			 console.log(formData);
			 $.ajax({
					method : 'POST',
					url : urlBase + "user/registerAgent",
					data: formData,
					contentType: "application/json",
					datatype: "json",
					success : function(data){
					
						sessionStorage.setItem('loggedId',data.id);
						
						 $('#inputModalRegister').modal('toggle');
					},
					error : function(error) {
						alert("Neuspesna registracija ");
					}
				});
			
		});
		
		function loadEndUsers(){
			 $.ajax({
					method : 'GET',
					url : urlBase + "user/allUsersEndUsers",
					success : function(data){

						if(data.length === 0){
							$('#tableUser').empty()
							$('#tableUser').append('<p>Nema registrovanih korisnika:(</p>')
						}else{
							
							for(var i = 0; i < data.length; i++){
							row="<tr>"+
								"<td>"+data[i].userFirstName+"</td>"
								+"<td>"+data[i].userLastName+"</td>"
								+"<td>"+data[i].userEmail+"</td>"
								+"<td>"+data[i].userType+"</td>"
								+"<td><button  class=\"btn btn-warning\" type=\"button\" value=\"blokiraj\" id=\"blokiraj\">"+"Blokiraj</button></td>"
								+"<td><button  class=\"btn btn-info\" type=\"button\" value=\"aktiviraj\" id=\"aktiviraj\">"+"Aktiviraj</button></td>"
								+"<td><button  class=\"btn btn-danger\" type=\"button\" value=\"ukloni\" id=\"ukloni\">"+"Ukloni</button></td>"
								+"<td style=\"display:none;\" type=\"hidden\" class=\"userId\" id=\"userId\">"+data[i].userId+"</td>"
								+"</tr>";
							console.log(row)
							console.log(data[i].userFirstName);
							$('#tableUser').append(row)
						}
						
						}
						
					},
					error : function(error) {
						//alert("Neuspesna registracija ");
					}
				});
			
		}
		function loadComments(){
			 $.ajax({
					method : 'GET',
					url : urlBase + "review/getUnapprovedComments",
					success : function(data){

						if(data.length === 0){
							$('#tableComments').empty();
							$('#tableComments').append('<p>Nema neobjavljeih komentara</p>');
						}else{
							
							for(var i = 0; i < data.length; i++){
							row="<tr>"+
								"<td>"+data[i].reviewComment+"</td>"
								+"<td>"+data[i].reviewEndUser.userFirstName+"</td>"
								+"<td>"+data[i].reviewEndUser.userLastName+"</td>"
								+"<td>"+data[i].reviewAccommodation.accName+"</td>"
								+"<td><button  class=\"btn btn-info\" type=\"button\" value=\"objavi\" id=\"objavi\">"+"Objavi</button></td>"
								+"<td style=\"display:none;\" type=\"hidden\" class=\"reviewId\" id=\"reviewId\">"+data[i].reviewId+"</td>"
								+"</tr>";
							console.log(row);
							//console.log(data[i].userFirstName);
							$('#tableComments').append(row);
						}
						
						}
						
					}
				});
		}
		
		$(document).on('click', '#blokiraj', function(){
			console.log("blokiraj dugme");
			tr_parent = $(this).closest("tr");
			$('#userId').val(tr_parent.find(".userId").html());
			var id=$("#userId").val();
			console.log(id);
			
			 $.ajax({
					method : 'PUT',
					url : urlBase + "user/blockUser/"+id,
					
					success : function(data){
						if(data.activated==false){
							alert("Korisnik je blokiran");
							console.log(data.activated);
						}
					},
					error : function(error) {
						alert("Neuspesna registracija ");
					}
				});
			
		});
		
		
		$(document).on('click', '#aktiviraj', function(){
			console.log("blokiraj dugme");
			tr_parent = $(this).closest("tr");
			$('#userId').val(tr_parent.find(".userId").html());
			var id=$("#userId").val();
			console.log(id);
			
			 $.ajax({
					method : 'PUT',
					url : urlBase + "user/activateUser/"+id,
					
					success : function(data){
						if(data.activated==true){
							alert("Korisnik je aktiviran");
							console.log(data.activated);
						}
					},
					error : function(error) {
						alert("Neuspesna registracija ");
					}
				});
			
		});
		
		$(document).on('click', '#ukloni', function(){
			console.log("blokiraj dugme");
			tr_parent = $(this).closest("tr");
			$('#userId').val(tr_parent.find(".userId").html());
			var id=$("#userId").val();
			console.log(id);
			
			 $.ajax({
					method : 'DELETE',
					url : urlBase + "user/deleteEndUser/"+id,
					
					success : function(data){
					
							alert("Korisnik je obrisan");
							loadEndUsers();
					},
					error : function(error) {
						//alert("Neuspesna registracija ");
					}
				});
			
		});

		$(document).on('click', '#objavi', function(){
			console.log("OBJAVI dugme");
			tr_parent = $(this).closest("tr");
			$('#reviewId').val(tr_parent.find(".reviewId").html());
			var id=$("#reviewId").val();
			
			 $.ajax({
					method : 'PUT',
					url : urlBase + "review/approveComment/"+id,
					
					success : function(data){
					
							alert("Komentar je uspesno objavljen");
							//loadEndUsers();
							loadComments();
					},
					error : function(error) {
						//alert("Neuspesna registracija ");
					}
				});
			
		});
		
		$(document).on('click', '#accTypeSave', function(){
			
			 formData = JSON.stringify({
				 accTypeName : $("#accTypeName").val()
			
			});
			
			 $.ajax({
					method : 'POST',
					url : urlBase + "accType/addAccType",
					data: formData,
					contentType: "application/json",
					datatype: "json",
					success : function(data){
						alert("Sacuvan tip smestaj");
						 $('#inputModalAccType').modal('toggle');
					},
					error : function(error) {
						//alert("Neuspesna registracija ");
					}
				});
			
		});
		
		$(document).on('click', '#categorySave', function(){
			
			 formData = JSON.stringify({
				 categoryName : $("#accCategory").val()
			
			});
			
			 $.ajax({
					method : 'POST',
					url : urlBase + "category/addCategory",
					data: formData,
					contentType: "application/json",
					datatype: "json",
					success : function(data){
						alert("Sacuvan tip smestaj");
						 $('#inputModalCategory').modal('toggle');
					},
					error : function(error) {
						//alert("Neuspesna registracija ");
					}
				});
			
		});
		

		$(document).on('click', '#inputModaladdService', function(){
			
			 formData = JSON.stringify({
				 serviceName : $("#addService").val()
			
			});
			
			 $.ajax({
					method : 'POST',
					url : urlBase + "service/addService",
					data: formData,
					contentType: "application/json",
					datatype: "json",
					success : function(data){
						alert("Sacuvana dodatna usluga");
						 $('#inputModaladdService').modal('toggle');
					},
					error : function(error) {
						//alert("Neuspesna registracija ");
					}
				});
			
		});
		
		
		
	});



	
