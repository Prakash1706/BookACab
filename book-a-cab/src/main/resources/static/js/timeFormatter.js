function timeFormatTo12Hr(time){
	
	var slotSplitted = time.split(":"); //[12,00,00]
    slotHour = slotSplitted[0];
    if(slotHour<12){
		if(slotHour==00){
			return "12"+":"+slotSplitted[1]+":"+slotSplitted[2]+" AM";
		}
		else{
			return slotHour+":"+slotSplitted[1]+":"+slotSplitted[2]+" AM";
		}
	}
	else{
		slotHour = slotHour-12;
		if (slotHour == 0) {
			return "12" + ":" + slotSplitted[1] + ":" + slotSplitted[2] + " PM";
		}
		else if (slotHour < 10) {
			return "0" + slotHour + ":" + slotSplitted[1] + ":" + slotSplitted[2] + " PM";
		}
		else {
			return slotHour + ":" + slotSplitted[1] + ":" + slotSplitted[2] + " PM";
		}
	}
	
}