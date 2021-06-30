
        
        
        var xhrSrc = new XMLHttpRequest();

        var xhrDest = new XMLHttpRequest();
        
        //On Load function tp call fetchSource() and fettchDestination()

        window.onload = validateBooking;

/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
        
        //Validate whether the User has already made booking or not
        
        var empId = "2038";
    	var empName = "Abishek";
    	
    	var time;
    	
    	//setInterval('validateBooking()',10000); //for every 10000ms, validateBooking() gets invoked
    	
    	var validateXhr = new XMLHttpRequest();
        
        function validateBooking(){
	
			validateXhr.open("GET","http://localhost:8080/user/booking/validate/"+empId,true);
			validateXhr.onreadystatechange=validationProcessResponse;
			
			validateXhr.send(null);
		}
		
		var validationResponse;

		function validationProcessResponse(){
			
			if(validateXhr.readyState == 4 && validateXhr.status == 200){
				fetchSource();
				fetchDestination();
				// getTime();
			}
			
			if(validateXhr.readyState == 4 && validateXhr.status == 228){
				
				window.location.href = "cab-app-ongoingtrip.html";
			}
			
			if(validateXhr.readyState == 4 && validateXhr.status == 227){
				
				validationResponse = JSON.parse(validateXhr.responseText);
				
				var srcOpt = document.createElement('option');
				srcOpt.innerText = validationResponse.source;
				srcOpt.selected = "selected";
			    document.querySelector('#source-opt').appendChild(srcOpt);
			   
			    var destOpt = document.createElement('option');
				destOpt.innerText = validationResponse.destination;
				destOpt.selected = "selected";
			    document.querySelector('#destination-opt').appendChild(destOpt);
			   
			    var dropOpt = document.createElement('option');
				dropOpt.innerText = validationResponse.dropPoint;
				dropOpt.selected = "selected";
			    document.querySelector('#dropPoint-opt').appendChild(dropOpt);
      	       
      	        var timeOpt = document.createElement('option');
				timeOpt.innerText = validationResponse.timeSlot;
				timeOpt.selected = "selected";
			    document.querySelector('#timeSlot-opt').appendChild(timeOpt);
      
				
			   document.getElementById("screen-title").innerHTML = "Ongoing Trip";
  	           document.getElementById('clear-btn').style.display="none";
  	      	   document.getElementById('bookACab-btn').style.display="none";
  	      	   document.getElementById('cancel-btn').style.display="block";
  	      	   
  	      	   document.querySelector('#source-opt').disabled = true;
      	       document.querySelector('#destination-opt').disabled = true;
      	       document.querySelector('#dropPoint-opt').disabled = true;
      	       document.querySelector('#timeSlot-opt').disabled = true;
			}
			
		}
		
		
/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/		

        //Fetches sources

        function fetchSource(){

            xhrSrc.open("GET","http://localhost:8080/user/booking/sources",true);
            xhrSrc.onreadystatechange=processResponse;
            xhrSrc.send(null);

        }

        
        function processResponse(){
        	if(xhrSrc.readyState == 4 && xhrSrc.status == 200){

        		var sources = JSON.parse(xhrSrc.responseText);
        		
        		var clearSource = document.getElementById("source-opt");
        	var srcLength = clearSource.options.length;
        	
                        for (i = srcLength-1; i > 0; i--) {
                          clearSource.options[i] = null;
                        }

                for(var i=0; i<sources.length; i++){

        			var opt = document.createElement("option");
        			

                    opt.innerHTML = sources[i].source;

                    document.getElementById("source-opt").options.add(opt);

                 }

              }
        }

        //Fetch Source - Ends
        
/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

        //Fetches Destinations

        var destinations;

        function fetchDestination(){

            xhrDest.open("GET","http://localhost:8080/user/booking/destinations",true);
            xhrDest.onreadystatechange=processResponseOfDestination;
            xhrDest.send(null);

        }

        function processResponseOfDestination(){
        	if(xhrDest.readyState == 4 && xhrDest.status == 200){

        		destinations = JSON.parse(xhrDest.responseText);
        		
        		var clearDestination = document.getElementById("destination-opt");
        	var destLength = clearDestination.options.length;
        	
                        for (i = destLength-1; i > 0; i--) {
                          clearDestination.options[i] = null;
                        }

                for(var i=0; i<destinations.length; i++){

        			var opt = document.createElement("option");
        			

                    opt.innerHTML = destinations[i].destination;

                    document.getElementById("destination-opt").options.add(opt);

                 }

              }
        }

        //Fetches Destinations - Ends
        
/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

        //For Populating DropPoints and TimeSlots based on Destination

        document.getElementById("destination-opt").addEventListener('change',function(){
        	
        	//Clearing the options of DropPoint drop down 
        	
        	var clearDropPoint = document.getElementById("dropPoint-opt");
        	var dropOptLength = clearDropPoint.options.length;
        	
                        for (i = dropOptLength-1; i > 0; i--) {
                          clearDropPoint.options[i] = null;
                        }
                        
        	//Clearing the options of TimeSlot drop down
            
            var clearTimeSlot = document.getElementById("timeSlot-opt");
        	var timeOptLength = clearTimeSlot.options.length;
        	
                        for (i = timeOptLength-1; i > 0; i--) {
                          clearTimeSlot.options[i] = null;
                        }
        	
        	var selectedDestination = document.querySelector('#destination-opt').value;
        	
        	
        	 for(var i=0; i<destinations.length; i++){
        		
        		
        		if((destinations[i].destination) == selectedDestination){
        			
        			for(var j=0; j<destinations[i].dropPoints.length; j++){
        				
        				//Binding options of DropPoint
        				
        				var dropPointOption = document.createElement("option");
        				
        				dropPointOption.innerHTML = destinations[i].dropPoints[j].dropPoint;
        				
        				document.getElementById("dropPoint-opt").options.add(dropPointOption);
        				
        				
        			}
        			
        			for(var k=0; k<destinations[i].timeSlots.length; k++){
        				
        				//Binding options of TimeSlots
        				
        				var timeSlotOption = document.createElement("option");
        				
        				var slot = destinations[i].timeSlots[k].timeSlot; //22:30:00
        				var slotSplitted = slot.split(":"); //[22,30,00]
        				slotHour = slotSplitted[0];
        				
        				if(slotHour<12){
							if(slotHour==00){
								timeSlotOption.innerHTML = "12"+":"+slotSplitted[1]+":"+slotSplitted[2]+" AM";
							}
							else{
								timeSlotOption.innerHTML = slotHour+":"+slotSplitted[1]+":"+slotSplitted[2]+" AM";
							}
							
						}
						else{
							slotHour = slotHour-12;
							if(slotHour < 10){
								timeSlotOption.innerHTML = "0"+slotHour+":"+slotSplitted[1]+":"+slotSplitted[2]+" PM";
							}
							else{
								timeSlotOption.innerHTML = slotHour+":"+slotSplitted[1]+":"+slotSplitted[2]+" PM";
							}
							
						}
        				
        				document.getElementById("timeSlot-opt").options.add(timeSlotOption);
        			}
        		}
        	} 
        	
        	
        });
        
      //End of Populating DropPoints and TimeSlots
      
/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
        
      //Validate for Empty Fields	
        
        function checkEmptyFields(){
        	
        	
        	if(document.getElementById("source-opt").selectedIndex == 0){
        		alert("Select Source");
        		return false;
        	}
        	
        	if(document.getElementById("destination-opt").selectedIndex == 0){
        		alert("Select Destination");
        		return false;
        	}
        	
        	if(document.getElementById("timeSlot-opt").selectedIndex == 0){
        		alert("Select TimeSlot");
        		return false;
        	}
        	
        	if(document.getElementById("dropPoint-opt").selectedIndex == 0){
        		alert("Select DropPoint");
        		return false;
        	}
        	
        	bookARideButtonClicked();
        }
      
      //Validate for Empty Fields - Ends
      
/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
      
      //Booking Confirmation PopUp
      
     
      
      var sourceSelected;
      var destinationSelected;
      var dropPointSelected;
      var timeSlotSelected
      
      function bookARideButtonClicked(){
    	 
    //Fetching server time
    
      var xhrTime = new XMLHttpRequest();
      
		xhrTime.open("GET","http://localhost:8080/user/booking/time",false);
		xhrTime.onreadystatechange=responseTime;
		xhrTime.send(null);
	

	function responseTime(){
	if(xhrTime.readyState == 4 && xhrTime.status == 200){
		
		time = xhrTime.responseText;
	}
	}
    	  
    	  $("#popUp-content").empty();
    	  
    	  sourceSelected = document.querySelector('#source-opt').value;
    	  destinationSelected = document.querySelector('#destination-opt').value;
    	  dropPointSelected = document.querySelector('#dropPoint-opt').value;
    	  timeSlotSelected = document.querySelector('#timeSlot-opt').value;
    	  
    	  let date = new Date();
    	  var currentDate;
		  if(timeSlotSelected.includes("AM")){
				currentDate = (date.getDate()+1) + "/" + (date.getMonth() + 1) + "/" +date.getFullYear();
		  }
		  else{
			currentDate = date.getDate() + "/" + (date.getMonth() + 1) + "/" +date.getFullYear();
		  }
    	  
    	  var bookingTimeDiv = document.createElement('div');
    	  bookingTimeDiv.className = " col-md-12 col-12 float-start confirm-booking-content";
    	  var timeSplit = time.split(":");
    	  var hours = timeSplit[0];
    	  
    	  if(hours<12){
				if(hours>=10){
					bookingTimeDiv.innerText = "Booking time: "+hours+":"+timeSplit[1]+":"+timeSplit[2]+" AM";
				}
				else{
					if(hours==00){
						bookingTimeDiv.innerText = "Booking time: "+"12"+":"+timeSplit[1]+":"+timeSplit[2]+" AM";
					}
					else{
						bookingTimeDiv.innerText = "Booking time: "+"0"+hours+":"+timeSplit[1]+":"+timeSplit[2]+" AM";
					}
					
				}
			}
			else{
				hours = hours-12;
				if(hours>=10){
					bookingTimeDiv.innerText = "Booking time: "+hours+":"+timeSplit[1]+":"+timeSplit[2]+" PM";
				}
				else{
					bookingTimeDiv.innerText = "Booking time: "+"0"+hours+":"+timeSplit[1]+":"+timeSplit[2]+" PM";
				}
				
			}
    	  
    	  var sourceDiv = document.createElement('div');
    	  sourceDiv.className = " col-md-12 col-12 float-start confirm-booking-content";
    	  sourceDiv.innerText = "Source: "+sourceSelected;
    	  
    	  var dropPointDiv = document.createElement('div');
    	  dropPointDiv.className = " col-md-12 col-12 float-start confirm-booking-content";
    	  dropPointDiv.innerText = "Drop Point: "+dropPointSelected;
    	  
    	  var dateDiv = document.createElement('div');
    	  dateDiv.className = " col-md-12 col-12 float-start confirm-booking-content";
    	  dateDiv.innerText = "Date of Travel: "+currentDate;
    	  
    	  var timeSlotDiv = document.createElement('div');
    	  timeSlotDiv.className = " col-md-12 col-12 float-start confirm-booking-content";
    	  timeSlotDiv.innerText = "Time Slot: "+timeSlotSelected;
    	  
    	  var popUp = document.getElementById("popUp-content");
    	  
    	  popUp.appendChild(bookingTimeDiv);
    	  popUp.appendChild(sourceDiv);
    	  popUp.appendChild(dropPointDiv);
    	  popUp.appendChild(dateDiv);
    	  popUp.appendChild(timeSlotDiv);
    	  
    	  
    	  document.getElementById("bookACab-btn").setAttribute('data-target','#confirmbooking');
      }
      
     
      
/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
      
      //Posting Booking request using AJAX call
      
	  var xhrBooking = new XMLHttpRequest();
      var bookingTimeSlot;
      function okButtonClicked(){
    	  
    	  var splittedTimeSlot = timeSlotSelected.split(":");
    	  if(splittedTimeSlot[2].includes("PM")){
				seconds = splittedTimeSlot[2].split(" ");
				//alert(Number(splittedTimeSlot[1]));
				if(Number(splittedTimeSlot[0])+12==24){
					bookingTimeSlot = "12"+":"+Number(splittedTimeSlot[1])+":"+seconds[0];
				}
				else{
					splittedTimeSlotHour = Number(splittedTimeSlot[0])+12;
					bookingTimeSlot = splittedTimeSlotHour +":"+Number(splittedTimeSlot[1])+":"+seconds[0];
				}
				
		  }
		  else{
				seconds = splittedTimeSlot[2].split(" ");
				if(Number(splittedTimeSlot[0])==12){
					bookingTimeSlot = "00"+":"+Number(splittedTimeSlot[1])+":"+seconds[0];
				}
				else if(Number(splittedTimeSlot[0])<10){
					bookingTimeSlot = "0"+Number(splittedTimeSlot[0]) +":"+Number(splittedTimeSlot[1])+":"+seconds[0];
				}
				else{
					bookingTimeSlot = Number(splittedTimeSlot[0]) +":"+Number(splittedTimeSlot[1])+":"+seconds[0];
				}
				
		  }
		//alert(bookingTimeSlot);
    	  
    	  
    	  var request = {"employeeId":empId,"employeeName":empName,"source":sourceSelected,"destination":destinationSelected,"dropPoint":dropPointSelected,"timeSlot":bookingTimeSlot};
    	  
    	  xhrBooking.open("POST","http://localhost:8080/user/booking/bookacab",true);
    	  xhrBooking.onreadystatechange=bookingResponse;
    	  
    	  xhrBooking.setRequestHeader("Content-Type", "application/json");
    	  
    	  xhrBooking.send(JSON.stringify(request));
      }
      
      var bookedResponseObj;
      
      function bookingResponse(){
  		
  		if(xhrBooking.readyState == 4 && xhrBooking.status == 200)
  		    {
  			validationResponse = JSON.parse(xhrBooking.responseText);
  	           //alert(bookingResponseObj.bookingId);
  	           document.getElementById("screen-title").innerHTML = "Ongoing Trip";
  	           document.getElementById('clear-btn').style.display="none";
  	      	   document.getElementById('bookACab-btn').style.display="none";
  	      	   document.getElementById('cancel-btn').style.display="block";
  	      	   
  	      	   document.querySelector('#source-opt').disabled = true;
      	       document.querySelector('#destination-opt').disabled = true;
      	       document.querySelector('#dropPoint-opt').disabled = true;
      	       document.querySelector('#timeSlot-opt').disabled = true;
  		    }
  		    
  		    if(xhrBooking.readyState == 4 && xhrBooking.status == 231){
  		    
  		    	alert("You can't book a Cab! You should make a booking 20 mins before the required time slot!");
  		    }
  	}
  	
/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/  
      
      //Cancel the ride
      
      var cancelXhr = new XMLHttpRequest();
      
      function cancelTheRideButtonClicked(){
    	  
    	  cancelXhr.open("PUT","http://localhost:8080/user/booking/cancel/"+validationResponse.bookingId,true);
    	  cancelXhr.onreadystatechange=cancelProcessResponse;
    	  cancelXhr.send(null);
      }
      
      function cancelProcessResponse(){
    	  
    	  if(cancelXhr.readyState == 4 && cancelXhr.status == 200){
    		  
    		   window.location.href = "cab-application-masterpage.html";
        	  
    	  }
    	  
    	  if(cancelXhr.readyState == 4 && cancelXhr.status == 228){
    	  
    	  alert("Cab has been assigned for you! You can't cancel your booking!");
    	  
    	  }
    	  
    	  
    	  
      }
     
