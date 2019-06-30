$(document).ready(function(){
		$('#container').hide();
		var urlBase = "http://localhost:8080/";
		loadEndUsers();
		loadComments();
		loadAccType();
		loadCategory();
		loadAddService();
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
		
		
		function loadAccType(){
			 $.ajax({
					method : 'GET',
					url : urlBase + "accType/getAccTypes",
					success : function(data){

						if(data.length === 0){
							$('#tableAccType').empty();
							$('#tableAccType').append('<p>Ne postoji ni jedan tip smestaja</p>');
						}else{
							
							for(var i = 0; i < data.length; i++){
							row="<tr>"+
								"<td class=\"accTypeName\">"+data[i].accTypeName+"</td>"
								
								+"<td><button  class=\"btn btn-info\" type=\"button\" value=\"objavi\" class=\"izmeniAccType\" id=\"izmeniAccType\">"+"Izmeni</button></td>"
								+"<td><button  class=\"btn btn-danger\" type=\"button\" value=\"objavi\" id=\"obrisiAccType\">"+"Obrisi</button></td>"
								+"<td style=\"display:none;\" type=\"hidden\" class=\"accTypeId\" id=\"accTypeId\">"+data[i].accTypeId+"</td>"
								+"</tr>";
							console.log(row);
							//console.log(data[i].userFirstName);
							$('#tableAccType').append(row);
						}
						
						}
						
					}
				});
		}
		
		function loadCategory(){
			 $.ajax({
					method : 'GET',
					url : urlBase + "category/getCategories",
					success : function(data){

						if(data.length === 0){
							$('#tableAccCategory').empty();
							$('#tableAccCategory').append('<p>Ne postoji ni jedana kategorija smestaja</p>');
						}else{
							
							for(var i = 0; i < data.length; i++){
							row="<tr>"+
								"<td class=\"accCategoryName\">"+data[i].categoryName+"</td>"
								
								+"<td><button  class=\"btn btn-info\" type=\"button\" value=\"objavi\" id=\"izmeniCategory\">"+"Izmeni</button></td>"
								+"<td><button  class=\"btn btn-danger\" type=\"button\" value=\"objavi\" id=\"obrisiCategory\">"+"Obrisi</button></td>"
								+"<td style=\"display:none;\" type=\"hidden\" class=\"categoryId\" id=\"categoryId\">"+data[i].categoryId+"</td>"
								+"</tr>";
							console.log(row);
							//console.log(data[i].userFirstName);
							$('#tableAccCategory').append(row);
						}
						
						}
						
					}
				});
		}
		
		function loadAddService(){
			 $.ajax({
					method : 'GET',
					url : urlBase + "service/getServices",
					success : function(data){

						if(data.length === 0){
							$('#formTableAddService').empty();
							$('#formTableAddService').append('<p>Ne postoji ni jedana kategorija smestaja</p>');
						}else{
							
							for(var i = 0; i < data.length; i++){
							row="<tr>"+
								"<td class=\"addServiceName\">"+data[i].serviceName+"</td>"
								
								+"<td><button  class=\"btn btn-info\" type=\"button\" value=\"objavi\" id=\"izmeniAddService\">"+"Izmeni</button></td>"
								+"<td><button  class=\"btn btn-danger\" type=\"button\" value=\"objavi\" id=\"obrisiAddService\">"+"Obrisi</button></td>"
								+"<td style=\"display:none;\" type=\"hidden\" class=\"addServiceId\" id=\"addServiceId\">"+data[i].serviceId+"</td>"
								+"</tr>";
							console.log(row);
							//console.log(data[i].userFirstName);
							$('#tableAccService').append(row);
						}
						
						}
						
					}
				});
		}
	
		//UPDATE ACCTYPE
		$(document).on('click', '#izmeniAccType', function(e){
			e.preventDefault();
		
			$("#inputModalAccTypeUPDATE").modal('toggle');
			tr_parent = $(this).closest("tr");
			$('#accTypeId').val(tr_parent.find(".accTypeId").html());
			var id=$("#accTypeId").val();
			$('#izmeniAccTypeNameId').val(tr_parent.find(".accTypeName").html());
			var name = $('#izmeniAccTypeNameId').val();
			
			$('#idAccType').val(tr_parent.find(".accTypeId").html());
			var nameID = $('#idAccType').val();
			
		
			
		});
		
		
		$(document).on('click', '#accTypeUpdate', function(e){
			var name = $('#izmeniAccTypeNameId').val();
			var nameID = $('#idAccType').val();
			
			console.log("---------------------------------");
			
			console.log(name);
			console.log(nameID);
			formData = JSON.stringify({
				accTypeName : name
			
			});
			 $.ajax({
					method : 'PUT',
					url : urlBase + "accType/updateAccType/"+nameID,
					data: formData,
					contentType: "application/json",
					datatype: "json",
					success : function(data){
							$("#tableAccType").empty();
							alert("Uspesno izmenjen tip smestaja");
							loadAccType();
						
					},
					error : function(error) {
						alert("Greska izmeniAccType ");
					}
				});
			 $("#inputModalAccTypeUPDATE").modal('toggle');
			
		});
		
		
		
		
		
		//UPDATE Category
		$(document).on('click', '#izmeniCategory', function(e){
			e.preventDefault();
		console.log("izmeniAccCategory")
			$("#inputModalCategoryUPDATE").modal('toggle');
			tr_parent = $(this).closest("tr");
			$('#accTypeId').val(tr_parent.find(".accTypeId").html());
			var id=$("#accTypeId").val();
			$('#izmeniAccCategory').val(tr_parent.find(".accCategoryName").html());
			var name = $('#izmeniAccCategory').val();
			
			$('#idCategory').val(tr_parent.find(".categoryId").html());
			var nameID = $('#idCategory').val();
			
		
			
		});
		
		
		$(document).on('click', '#accCategoryUpdate', function(e){
			var name = $('#izmeniAccCategory').val();
			var nameID = $('#idCategory').val();
			
			console.log("---------------------------------");
			
			console.log(name);
			console.log(nameID);
			formData = JSON.stringify({
				categoryName : name
			
			});
			
			 $.ajax({
					method : 'PUT',
					url : urlBase + "category/updateCategory/"+nameID,
					data: formData,
					contentType: "application/json",
					datatype: "json",
					success : function(data){
							$("#tableAccCategory").empty();
							alert("Uspesno izmenjena kategorija smestaja");
							loadCategory();
						
					},
					error : function(error) {
						alert("Greska prilikom izmene kategorije  ");
					}
				});
			 $("#inputModalCategoryUPDATE").modal('toggle');
			
		});
		
		
		
		//UPDATE Service
		$(document).on('click', '#izmeniAddService', function(e){
			e.preventDefault();
			console.log("izmeniAccService")
			$("#inputModalServiceUPDATE").modal('toggle');
			tr_parent = $(this).closest("tr");
			$('#accTypeId').val(tr_parent.find(".accTypeId").html());
			var id=$("#accTypeId").val();
			$('#izmeniAccService').val(tr_parent.find(".addServiceName").html());
			var name = $('#izmeniAccService').val();
			
			$('#idService').val(tr_parent.find(".addServiceId").html());
			var nameID = $('#idService').val();
			
		
			
		});
		
		
		$(document).on('click', '#accServiceUpdate', function(e){
			var name = $('#izmeniAccService').val();
			var nameID = $('#idService').val();
			
			console.log("---------------------------------");
			
			console.log(name);
			console.log(nameID);
			formData = JSON.stringify({
				serviceName : name
			
			});
			
			 $.ajax({
					method : 'PUT',
					url : urlBase + "service/updateService/"+nameID,
					data: formData,
					contentType: "application/json",
					datatype: "json",
					success : function(data){
							$("#tableAccService").empty();
							alert("Uspesno izmenjeno");
							loadAddService();
						
					},
					error : function(error) {
						alert("Greska prilikom izmene dodatnih usluga  ");
					}
				});
			 
			 $("#inputModalServiceUPDATE").modal('toggle');
			
		});
		
		
		
		
		
		
		
		
		
	
		
		
		//BLOKIRAJ USERA
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
						 $("#tableAccType").empty();
						loadAccType();
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
						 $("#tableAccCategory").empty();
						 loadCategory();
						
					},
					error : function(error) {
						//alert("Neuspesna registracija ");
					}
				});
			
		});
		

		$(document).on('click', '#addServiceSave', function(){
			console.log("event");
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
						 $("#tableAccService").empty();
						alert("Sacuvana dodatna usluga");
						 $('#inputModaladdService').modal('toggle');
						
						 loadAddService();
					},
					error : function(error) {
						//alert("Neuspesna registracija ");
					}
				});
			
		});
		
		
		
		
		
		
		
		
		//DELETE ACC SERVICE
		
		$(document).on('click', '#obrisiCategory', function(){
			
			tr_parent = $(this).closest("tr");
			$('#categoryId').val(tr_parent.find(".categoryId").html());
			var id=$("#categoryId").val();
			console.log(id);
			
			 $.ajax({
					method : 'DELETE',
					url : urlBase + "category/deleteCategory/"+id,
					
					success : function(data){
						tableAccCategory
						$("#tableAccCategory").empty();
							alert("Kategorija je obrisana");
							loadCategory();
					},
					error : function(error) {
						alert("Neuspesno brisanje ");
					}
				});
			
		});
		
		//DELETE ACC TYPE
		$(document).on('click', '#obrisiAccType', function(){
			
			tr_parent = $(this).closest("tr");
			$('#accTypeId').val(tr_parent.find(".accTypeId").html());
			var id=$("#accTypeId").val();
			console.log(id);
			
			 $.ajax({
					method : 'DELETE',
					url : urlBase + "accType/deleteAccType/"+id,
					
					success : function(data){
							$("#tableAccType").empty();
							alert("Obrisano");
							loadAccType();
					},
					error : function(error) {
						alert("Neuspesno brisanje ");
					}
				});
			
		});
		
		
		//DELETE ACC SERVICE
		$(document).on('click', '#obrisiAddService', function(){
			
			tr_parent = $(this).closest("tr");
			$('#addServiceId').val(tr_parent.find(".addServiceId").html());
			var id=$("#addServiceId").val();
			console.log(id);
			
			 $.ajax({
					method : 'DELETE',
					url : urlBase + "service/deleteService/"+id,
					
					success : function(data){
						 	$("#tableAccService").empty();
							alert("Kategorija je obrisana");
							loadAddService();
					},
					error : function(error) {
						alert("Neuspesno brisanje ");
					}
				});
			
		});
		
	});



	
