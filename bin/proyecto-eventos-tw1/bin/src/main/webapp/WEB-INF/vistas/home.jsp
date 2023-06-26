<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet"
		  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<script src="https://cdn.tailwindcss.com"></script>
	<title>Home</title>
</head>

<body>
<!-- Barra de navegación -->
<nav class="flex items-center justify-between flex-wrap bg-violet-500 p-6">
	<div class="flex items-center flex-shrink-0 text-white mr-6">
		<img src="../img/logo.png" alt="" class="w-8 m-1 rounded">
		<span class="font-semibold text-xl tracking-tight">Mi App de Eventos</span>
	</div>
	<div class="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
		<div class="text-sm lg:flex-grow">
			<input class="bg-violet-800 appearance-none border-2 border-violet-800 rounded py-2 px-4 text-violet-300 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" type="text" placeholder="Buscar...">
		</div>
		<div>
			<a href="#" class="mx-2 text-white hover:text-violet-300">
				<i class="fa-solid fa-bell"></i>
			</a>
			<a href="#" class="mx-2 text-white hover:text-violet-300">
				<i class="fa-solid fa-user"></i>
			</a>
		</div>
	</div>
</nav>

<!-- Filtros -->
<div class="flex justify-center items-center my-4">
	<div class="border rounded-md p-4 bg-white">
		<h2 class="text-lg font-semibold mb-2">Filtrar Eventos</h2>
		<form action="/home/filtrar" method="GET">
			<div class="flex flex-wrap items-center">
				<div class="mr-4">
					<label for="filtro-ciudad" class="block mb-1">Ciudad:</label>
					<input type="text" id="filtro-ciudad" name="localidad" class="px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500" placeholder="Ingrese la ciudad">
				</div>
				<div class="mr-4">
					<label for="filtro-fecha" class="block mb-1">Fecha:</label>
					<input type="date" id="filtro-fecha" name="filtro-fecha" class="px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
				</div>
				<div class="mr-4">
					<label for="filtro-categoria" class="block mb-1">Categor&iacute;a:</label>
					<select id="filtro-categoria" name="filtro-categoria" class="px-3 py-2 border rounded-md focus:outline-none focus:ring-blue-500">
						<option value="">Seleccione una categor&iacute;a</option>
						<option value="Deportivo">Deportivo</option>
						<option value="Musical">Musical</option>
						<option value="Bailable">Bailable</option>
						<option value="Teatro">Teatro</option>
						<option value="Recital">Recital</option>
						<option value="Cine">Cine</option>

					</select>
				</div>
				<div>
					<button type="submit" class="px-4 py-2 text-white bg-violet-500 rounded-md hover:bg-violet-600">Filtrar</button>
					<c:if test="${not empty error}">
						<h4><span>${error}</span></h4>
						<br>
					</c:if>
					${mensaje}

				</div>
			</div>
		</form>
	</div>
</div>


<!-- Cards -->
<div class="flex flex-wrap justify-center">

	<div class="max-w-sm rounded overflow-hidden shadow-lg m-4">
		<img class="w-full" src="../img/clasico.jpg" alt="Evento">
		<div class="px-6 py-4">
			<div class="font-bold text-xl mb-2">Supercl&aacute;sico</div>
			<p class="text-gray-700 text-base">Fecha: 01/01/2022</p>
			<p class="text-gray-700 text-base">Ciudad: Buenos Aires</p>
			<div class="my-4">
				<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">Deportivo</span>
				<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">F&uacute;tbol</span>
			</div>
		</div>
		<div class="flex justify-center px-6 pt-4 pb-2 mb-4">
			<button class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full">Comprar entradas</button>
		</div>
	</div>

	<div class="max-w-sm rounded overflow-hidden shadow-lg m-4">
		<img class="w-full" src="../img/luismi.jpg" alt="Evento">
		<div class="px-6 py-4">
			<div class="font-bold text-xl mb-2">Luis Miguel en Buenos Aires</div>
			<p class="text-gray-700 text-base">Fecha: 01/01/2022</p>
			<p class="text-gray-700 text-base">Ciudad: Buenos Aires</p>
			<div class="my-4">
				<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">Musical</span>
				<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">Gastron&oacute;mico</span>
			</div>
		</div>
		<div class="flex justify-center px-6 pt-4 pb-2">
			<button class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full">Comprar entradas</button>
		</div>
	</div>

	<div class="max-w-sm rounded overflow-hidden shadow-lg m-4">
		<img class="w-full" src="../img/feria.jpg" alt="Evento">
		<div class="px-6 py-4">
			<div class="font-bold text-xl mb-2">Feria del Libro</div>
			<p class="text-gray-700 text-base">Fecha: 01/01/2022</p>
			<p class="text-gray-700 text-base">Ciudad: Buenos Aires</p>
			<div class="my-4">
				<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">Feria</span>
				<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">Cultural</span>
			</div>
		</div>
		<div class="flex justify-center px-6 pt-4 pb-2">
			<button class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full">Comprar entradas</button>
		</div>
	</div>
</div>
<div class="flex justify-evenly px-6 pt-4 pb-2"><a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full" href="/mostrar-eventos">Ver todos los eventos</a>
												<a class="bg-violet-500 hover:bg-violet-700 text-white font-bold py-2 px-4 rounded-full" href="/registrar-evento">Registra un evento</a></div>
<!-- Google Maps -->
<div class="flex justify-center">
	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d26283.162649244754!2d-58.458951284375!3d-34.5688622!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bcb5a28c37ff9b%3A0x289b0f07f03e748b!2sHip%C3%B3dromo%20de%20Palermo!5e0!3m2!1ses!2sar!4v1683763795538!5m2!1ses!2sar" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>      </div>

<!-- Footer  -->

<footer class="bg-violet-500 mt-4 py-8">
	<div class="container mx-auto px-4">
		<div class="flex flex-wrap justify-between">
			<div class="w-full lg:w-6/12 px-4">
				<h2 class="text-2xl font-semibold text-white">Nuestras redes sociales:</h2>
			</div>
			<div class="w-full lg:w-6/12 px-4">
				<ul class="flex flex-wrap list-none justify-end">
					<li>
						<a href="#" class="text-white hover:text-violet-300 mr-4">
							<i class="fab fa-facebook"></i>
						</a>
					</li>
					<li>
						<a href="#" class="text-white hover:text-violet-300 mr-4">
							<i class="fab fa-twitter"></i>
						</a>
					</li>
					<li>
						<a href="#" class="text-white hover:text-violet-300">
							<i class="fab fa-instagram"></i>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</footer>

</body>

</html>