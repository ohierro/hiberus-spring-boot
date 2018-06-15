
window.onload = desplegar;

function desplegar() {
	var casilla = document.getElementsByClassName("menu");
	for(var i = 0; i<casilla.length; i++){
		casilla[i].addEventListener("click", desp, true);

	}

	function desp(eve) {
		var idCasilla = eve.target.id;
		var casilla = document.getElementById(idCasilla);
		var cas = eve.target;

		switch(idCasilla){
		case "home":
			alert("en Home");
			break;
		case "create":
			options("createOptions");
			eve.target.addEventListener("mouseout", salir, true);
			break;
		case "asign":
			alert("en asign");
			break;
		case "history":
			options("historyOptions");
			eve.target.addEventListener("mouseout", salir, true);
			break;
		case "propos":
			alert("en propos");
			break;
		case "equip":
			options("equipOptions");
			eve.target.addEventListener("mouseout", salir, true);
			break;
		}
	}
}


function over(eve) {
	var style = document.getElementsByClassName(eve.target.className);
	for(var i = 0; i<style.length; i++){
		style[i].style.display = "inherit";
		eve.target.style.backgroundColor="#808080";
	}
}

function out(eve) {

	var style = document.getElementsByClassName(eve.target.className);
	for(var i = 0; i<style.length; i++){
		style[i].style.display = "none";
		eve.target.style.backgroundColor="black";

	}
}

function options(clase) {
	var style = document.getElementsByClassName(clase);
	for(var i = 0; i<style.length; i++){
		style[i].style.display = "inherit";
		style[i].addEventListener("mouseover", over, true);
		style[i].addEventListener("mouseout", out, true);
	}
}

function salir(eve) {
	siblingName = eve.target.nextElementSibling.className;
	var menu = document.getElementsByClassName(siblingName);
	for(var i = 0; i < menu.length; i++){
		menu[i].style.display = "none";
	}

}


