<html>
<link rel="stylesheet" href="css/default.css">
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/actions.js"></script>
<body>
<div class="headerBarTitle" >
<h1 align="center">Processo Seletivo</center></h1>
<h2 align="center">Assessor I TI</h2>
<h3 align="center">Divisão Construção de Aplicações</h3>
</div>
<div class="headBarSubTitle">
<h3 align="center">Estudo de Caso - Inova Asset Management</h3>
</div>
<div>

<div style="width: 30%; float: left; padding: 10px">
	<div style="padding-bottom: 10px">Selecione o perfil de investidor para listar os fundos disponíveis</div>
	<div style="width: 180px">
			<div class="optPerfil" onClick="verFundos('BAIXO')"><a class="aPerfil" href="#" >Conservador</a></div>
			<div class="optPerfil" onClick="verFundos('MEDIO')"><a class="aPerfil" href="#">Moderado</a></div>
			<div class="optPerfil" onClick="verFundos('ALTO')"><a class="aPerfil" href="#">Arrojado</a></div>
	
	</div>
</div>
<div style="width: 60%; float: left; padding: 10px">
	<div style="padding-bottom: 10px"> Fundos disponíveis</div>
	<div id="divFundos"><table id="tbFundos"></table>
	
	
	</div>	
</div>
</div>
</body>
<script>

function verFundos(perfil)
	{
		$.ajax({
				url: 'action?perfil=' + perfil,
				success: function (response)
					{
						var tb = "<tr class=thFundos><th class='thFundos'>Código do Fundo</th><th class='thFundos'>Nome do Fundo</th><th class='thFundos'>CNPJ</th></tr>";
						const tr = response.split("|,");
						for(i in tr)
							{
								const obj = JSON.parse(tr[i]);
				
								tb += '<tr class=tdFundos>';
								tb += '<td class=tdFundos>' + obj.COD_FUNDO + '</td>';
								tb += '<td class=tdFundos>' + obj.NOME_FUNDO + '</td>';
								tb += '<td class=tdFundos>' + obj.CNPJ_FUNDO + '</td>';
								tb += '</tr>';
							}
						$("#tbFundos").html("");
						$("#tbFundos").append(tb);
					}

				});
	};
	

</script>
</html>
