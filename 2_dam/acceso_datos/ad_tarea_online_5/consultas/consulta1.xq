for $a in in doc("colecciones.xml")//libro[@publicacion=2002] order by $a/titulo return $a/titulo/text()
