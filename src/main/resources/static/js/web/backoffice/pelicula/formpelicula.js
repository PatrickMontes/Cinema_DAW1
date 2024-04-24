 $(document).ready(function(){
      $("#btnAgregarPelicula").click(function(){
          $("#agregarPeliculaModal").modal('show');

      });

      $(".modal .cerrar").click(function(){
          $(this).closest(".modal").modal('hide');
      });
  });

$(document).on("click", ".btnactualizar", function(){
    var titulo = $(this).attr("data-peltitulo");
    var genero = $(this).attr("data-pelgenero");
    var duracion = $(this).attr("data-pelduracion");
    var imagen = $(this).attr("data-pelimagen");
    var peliculaId = $(this).attr("data-pelcod");

    $("#txttitulo").val(titulo);
    $("#txtgenero").val(genero);
    $("#txtduracion").val(duracion);
    $("#hddpelcod").val(peliculaId);

    $("#modalPelicula").modal("show");
});