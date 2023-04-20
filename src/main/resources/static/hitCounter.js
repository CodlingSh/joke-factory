// Define a function for the hit counter
function getTheHits() {
	$.get("/hitCount", function(result) {
		$("#numHits").html(result)    				
	})
}

// Define a function that calls the hit counter once and then sets it to fire every 3 seconds
function InstantSetInterval(interv) {
	getTheHits();
	return setInterval(getTheHits, interv)
}
    		
// Call the 2nd function, so the API call fires once instantly and then fires every three seconds
InstantSetInterval(3000);