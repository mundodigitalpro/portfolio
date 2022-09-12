for $libro in doc("colecciones.xml")//libro
for $prestado in doc("colecciones.xml")/biblioteca/prestamos/entrada
where $prestado/titulo = $libro/titulo
return <resultado>{$libro/autor, $libro/paginas}</resultado>