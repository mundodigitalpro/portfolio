for $a in /biblioteca/libros/libro[@publicacion=2002] order by $a/titulo return $a/titulo/text()