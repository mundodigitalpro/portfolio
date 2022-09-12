for $titulo in doc("colecciones.xml")//libro let $autor := $titulo//autor 
where count($autor) > 1
order by $titulo/titulo 
return $titulo/titulo/text()