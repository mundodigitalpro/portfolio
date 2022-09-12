for $libro in doc("colecciones.xml")//libro
for $prestado in doc("colecciones.xml")//entrada
where $prestado/titulo = $libro/titulo
let $nombre := $prestado//nombre
group by $nombre
return <resultado>{$prestado/prestamo/lector/nombre, sum($libro/paginas)}</resultado>