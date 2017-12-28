// JavaScript Document

	
		$(document).ready(function () {
		$('.page-sidebar-menu li.main-menu').click(function () {
		$(this).children('.sub-menu').slideToggle();
		});
		
		$('.page-sidebar-menu li.main-menu li').click(function( event ) {
event.stopPropagation();
		});
		
	$('.sidebar').click(function() {
		$('.page-sidebar-menu').toggleClass('show-sidebar');
		
	});
		
			
		});
		
		
