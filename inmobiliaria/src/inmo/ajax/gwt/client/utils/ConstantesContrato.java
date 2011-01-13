package inmo.ajax.gwt.client.utils;

import inmo.ajax.gwt.client.db.ClienteBean;
import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.EnteBean;
import inmo.ajax.gwt.client.db.GarantiaBean;
import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.ajax.gwt.client.db.PersonaBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.PropietarioBean;

import java.util.Date;
import java.util.List;

public class ConstantesContrato
{
	public static final String _01_INMUEBLE = "INMUEBLE QUE SE ALQUILA:"; 
	public static final String _02_TERMINO = "TÉRMINO: ";
	public static final String _03_PRECIO = "PRECIO:";
	public static final String _04_PAGO = "PAGO:";
	public static final String _05_CONDICIONES_DEL_INMUEBLE = "CONDICIONES " +
			"DEL INMUEBLE:";
	public static final String _06_INTRANSFERIBILIDAD = "INTRANSFERIBILIDAD:";
	public static final String _07_GRUPO_FAMILIAR = "GRUPO FAMILIAR:";
	public static final String _08_PROHIBICIONES = "PROHIBICIONES:";
	public static final String _09_IMPUESTOS_TASAS_SERVICIOS = "IMPUESTOS, " +
			"TASAS Y SERVICIOS:";
	public static final String _10_RESPONSABILIDADES_LOCATARIA = 
		"RESPONSABILIDADES:";
	public static final String _11_RESPONSABILIDADES_LOCADORA = "";
	public static final String _12_CONSIGNACION_DE_LLAVES= "CONSIGNACIÓN DE " +
			"LLAVES:";
	public static final String _13_INCUMPLIMIENTO_DESALOJO = "INCUMPLIMIENTO " +
			"Y DESALOJO:";
	public static final String _14_RESCISION = "RESCISIÓN:";
	public static final String _15_SELLADOS = "SELLADOS:";
	public static final String _16_COSTOS_HONORARIOS = "COSTOS Y HONORARIOS:";
	public static final String _17_GARANTES = "GARANTES:";
	public static final String _18_REEMPLAZO_GARANTES = "REEMPLAZO DE LOS " +
			"GARANTES-PROHIBICIONES-OBLIGACIONES DE LOS GARANTES:";
	public static final String _19_DOMICILIOS = "DOMICILIOS:";
	public static final String _20_JURISDICCION = "JURISDICCIÓN:";
	
	
	public static String getPartes(EnteBean propietario, EnteBean cliente)
	{
		String clausula = "Entre " +
		getDatosPersona(propietario) + 
		", en adelante denominada LA LOCADORA, y " +
		getDatosPersona(cliente) +
		", en adelante denominada LA LOCATARIA, deciden de común acuerdo " +
		"celebrar el siguiente CONTRATO DE LOCACIÓN, el cual se regirá bajo " +
		"las condiciones y cláusulas que a continuación se detallan:";
		
		return clausula;
	}
	
	private static String getDatosPersona(EnteBean persona)
	{
		TipoPersona tipoPersona = persona.getTipoPersona();
		StringBuilder retornar = new StringBuilder();
		
		if (tipoPersona == TipoPersona.ORGANIZACION) 
		{
			
		}
		else if (tipoPersona == TipoPersona.CLIENTE)
		{
			ClienteBean cliente = (ClienteBean) persona;
			if (cliente.getSexo().equals("m"))
			{
				retornar.append("El Sr. "); 
			}
			else
			{
				retornar.append("La Sra. "); 
			}
			retornar.append(cliente.getApellido().toUpperCase() + ", ");
			retornar.append(cliente.getNombres() + ", ");
			retornar.append(cliente.getTipoDocumento().getTipo() + " N° ");
			retornar.append(cliente.getNumeroDocumento() + ", con domicilio en ");
					
			DireccionBean direccion = null;
			for (DireccionBean dir : cliente.getDirecciones())
			{
				if (dir.getTipoUbicacion().getNombre().
						equals("Particular"))
				{
					direccion = dir;
				}
			}
			if (direccion == null)
			{
				direccion = cliente.getDirecciones()[0];
			}
			
			retornar.append(direccion.getCalle() + " N° " +
				direccion.getNumero() + " B° " +
				direccion.getBarrios().getNombre() + " de la ciudad de " +
				direccion.getBarrios().getNombreLocalidad() + 
				", Provincia de " +
				direccion.getBarrios().getNombreProvincia());

		}
		else if (tipoPersona == TipoPersona.PROPIETARIO)
		{
			PropietarioBean propietario = (PropietarioBean) persona;
			if (propietario.getSexo().equals("m"))
			{
				retornar.append("El Sr. "); 
			}
			else
			{
				retornar.append("La Sra. "); 
			}
			retornar.append(propietario.getApellido().toUpperCase() + ", " +
				propietario.getNombres() + ", " +
				propietario.getTipoDocumento().getTipo() + " N° " +
				propietario.getNumeroDocumento() + ", con domicilio en ");
					
			DireccionBean direccion = null;
			for (DireccionBean dir : propietario.getDirecciones())
			{
				if (dir.getTipoUbicacion().getNombre().
						equals("Particular"))
				{
					direccion = dir;
				}
			}
			if (direccion == null)
			{
				direccion = propietario.getDirecciones()[0];
			}
			retornar.append(direccion.getCalle() + " N° " +
				direccion.getNumero() + " B° " +
				direccion.getBarrios().getNombre() + " de la ciudad de " +
				direccion.getBarrios().getNombreLocalidad() + 
				", Provincia de " +
				direccion.getBarrios().getNombreProvincia());
		}
		else
		{
			PersonaBean personaBean = (PersonaBean) persona;
			if (personaBean.getSexo().equals("m"))
			{
				retornar.append("El Sr. "); 
			}
			else
			{
				retornar.append("La Sra. "); 
			}
			retornar.append(personaBean.getApellido().toUpperCase() + ", " +
				personaBean.getNombres() + ", " +
				personaBean.getTipoDocumento().getTipo() + " N° " +
				personaBean.getNumeroDocumento() + ", con domicilio en ");
					
			DireccionBean direccion = null;
			for (DireccionBean dir : personaBean.getDirecciones())
			{
				if (dir.getTipoUbicacion().getNombre().
						equals("Particular"))
				{
					direccion = dir;
				}
			}
			if (direccion == null)
			{
				direccion = personaBean.getDirecciones()[0];
			}
			retornar.append(direccion.getCalle() + " N° " +
				direccion.getNumero() + " B° " +
				direccion.getBarrios().getNombre() + " de la ciudad de " +
				direccion.getBarrios().getNombreLocalidad() + 
				", Provincia de " +
				direccion.getBarrios().getNombreProvincia());
		}
		return retornar.toString();
	}

	public static String getInmueble(PropiedadBean propiedad, 
			String descripcionPropiedad, boolean permitirModificaciones)
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append(" LA LOCADORA cede en LOCACIÓN a LA LOCATARIA, y " +
				"ésta acepta, un inmueble");
		if (propiedad.getTipoPropiedad().getNombre().equals("Casa") || 
				propiedad.getTipoPropiedad().getNombre().equals("Departamento"))
		{
			clausula.append(" apto para casa-habitación");
		}
		clausula.append(" ubicado en ");
		clausula.append(descripcionPropiedad);
		clausula.append(".- LA LOCATARIA recibe el inmueble que alquila, " +
				"desocupado, en buen estado de habitabilidad, y manifestando " +
				"a la vez que los artefactos  existentes, vidrios, herrajes, " +
				"cerraduras, llaves de luz, todos los portalámparas con sus " +
				"respectivas lámparas y demás efectos, se encuentran en buen " +
				"estado y funcionamiento.- LA LOCATARIA se compromete a la " +
				"vez ");
		if (!permitirModificaciones)
		{
			clausula.append(" a no introducir modificaciones de ninguna " +
					"naturaleza en lo locado, sin el previo consentimiento " +
					"escrito de LA LOCADORA, quedando las que fueran por " +
					"ella autorizadas, en beneficio  de la propiedad;");
		}
		clausula.append("a tomar a su cargo todos los gastos de reparaciones" +
				" y mantenimiento que fueran necesarios, lo que aquí se pacta" +
				" demandaré, así como al pago de los objetos que se" +
				" deterioraren, destruyeren o faltaren, quedando convenido" +
				" que al desocupar la parte LOCATARIA el inmueble, y" +
				" devolverlo a la parte LOCADORA, si ésta verificare la" +
				" existencia de deterioros, averías, desperfectos o cosas" +
				" faltantes, no cesaren las obligaciones de la parte" +
				" LOCATARIA, la cual se obliga a entregar el inmueble al" +
				" vencimiento del contrato, en las mismas condiciones en que" +
				" lo recibe de la parte LOCADORA.- Deberá la parte LOCATARIA" +
				" dar en todo caso, aviso a la parte LOCADORA dentro de las" +
				" 72 hs. de cualquier desperfecto mayor que se produzca en el" +
				" inmueble, y permitir a LA LOCADORA el acceso al inmueble a" +
				" efectos de su inspección, y comunicarle por escrito y de" +
				" inmediato cualquier situación que pudiere causar un" +
				" deterioro o afectar la seguridad del mismo.-");
		return clausula.toString();
	}
	
	@SuppressWarnings("deprecation")
	public static String getTermino(String fecha, String periodo, 
			String interes, String tipoInteres, boolean permitirUtilizar)
	{
		StringBuilder clausula = new StringBuilder();
		int meses = Integer.parseInt(periodo) * 12;
		clausula.append("1) Se establece como plazo de duración de este" +
				" contrato el de ");
		clausula.append(Utilidades.numeroToString(periodo).toUpperCase());
		clausula.append((meses == 12) ? " AÑO (" : " AÑOS (");
		clausula.append(meses);
		clausula.append(" meses), el que se comenzará a contar a partir del " +
				"día ");
		clausula.append(Utilidades.getDateImprimible(fecha));
		clausula.append(", venciendo en consecuencia el día ");
		Date date = Utilidades.getDate(fecha);
		date.setYear(date.getYear()+Integer.valueOf(periodo));
		clausula.append(Utilidades.getDateImprimible(Utilidades.
				restarUnDia(date)));
		clausula.append(", sin necesidad de notificación ni comunicación de " +
				"ninguna naturaleza. 2) Este plazo se considerará " +
				"improrrogable, salvo convención ulterior entre las partes " +
				"que expresamente estableciera lo contrario. En caso de " +
				"operarse su vencimiento sin que la parte LOCATARIA hubiese " +
				"restituido el inmueble a satisfacción de la parte LOCADORA, " +
				"queda convenido que aquella, deberá abonar a la parte " +
				"LOCADORA una multa diaria por incumplimiento contractual " +
				"que se pacta en un ");
		clausula.append(Utilidades.numeroToString(interes).toUpperCase());
		clausula.append(" POR CIENTO ");
		clausula.append(tipoInteres.toUpperCase());
		clausula.append(" (");
		clausula.append(interes);
		clausula.append("%), tomando en cuenta el último alquiler abonado.- " +
				"3) La continuación de la parte LOCATARIA en el uso y goce " +
				"del inmueble una vez vencido el plazo pactado, así como la " +
				"extensión por parte de la parte LOCADORA de recibos de " +
				"alquileres en meses posteriores al del vencimiento del " +
				"contrato, no implica que exista tácita reconducción del " +
				"contrato, pudiendo la parte LOCADORA exigir la devolución " +
				"del inmueble en cualquier término, todo ello conforme al " +
				"art. 1622 del Código Civil.-");
		
		return clausula.toString();
	}
	
	public static String getPrecio(String precioNumero, String precioLetras, 
			MonedaBean moneda, boolean renegociar, boolean incluyeIVA)
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("Queda convenido y claro, libre y voluntariamente " +
				"entre las partes y así lo entienden, como precio mensual " +
				"del alquiler, la suma de ");
		clausula.append(moneda.getDescripcion().toUpperCase());
		clausula.append(" ");
		clausula.append(precioLetras.toUpperCase());
		clausula.append(" (");
		clausula.append(moneda.getNombre());
		clausula.append(precioNumero);
		clausula.append(".-) siendo éste el importe mínimo a pagar por LA " +
				"LOCATARIA. ");
		if (renegociar)
		{
			clausula.append("Dada la actual regulación legal que impide la " +
					"utilización de mecanismos de ajuste, indexación o " +
					"actualización de los precios de estos contratos, y " +
					"frente a la realidad económica que marca que los " +
					"precios inmobiliarios se modifican periódicamente " +
					"lo que determina la necesidad de ajustes en los " +
					"precios de todos los contratos, las partes se " +
					"comprometen expresamente a renegociar el precio " +
					"locativo en forma anual a la fecha de finalización " +
					"del primer año de este contrato.  Dicha suma quedará " +
					"sujeta a reajuste de precio, previo acuerdo de partes " +
					"sobre la base de índices indicativos o referentes de " +
					"la construcción, o CER o CVS o Costo de Vida, o bien " +
					"según las leyes y/o decretos que pudiera dictar el " +
					"Poder Ejecutivo Nacional y/o bien los principios que " +
					"marcare la Jurisprudencia, en todos los casos siempre " +
					"se tendrá en cuenta para la determinación del reajuste " +
					"del alquiler la tesis de las cargas compartidas y buena " +
					"fe de las partes. El precio así determinado regirá " +
					"exclusivamente hacia el futuro sin efectos retroactivos " +
					"respecto de los alquileres ya percibidos por la " +
					"LOCADORA. El procedimiento implementado será una " +
					"reunión cada doce meses entre ambas partes y se " +
					"pactará de mutuo acuerdo según el Art. 1197 del " +
					"Código Civil. Para el caso de no llegar a un acuerdo " +
					"en la reunión, se someterá a la decisión de terceros " +
					"además cualquiera de las partes podrá rescindir el " +
					"presente contrato previa notificación fehaciente con " +
					"90 días de anticipación. ");

			
		}
		if (!incluyeIVA)
		{
			clausula.append("El importe fijado para el precio del alquiler " +
					"mensual no contempla monto alguno en concepto de " +
					"impuesto al valor agregado (IVA) y en caso de " +
					"corresponder será adicionado por LA LOCATARIA.-");
		}
		
		return clausula.toString();
	}
	
	public static String getPago(PropiedadBean propiedad, String tipoInteres, 
			String interes, String diaDesde, String diaHasta)
	{
		StringBuilder clausula = new StringBuilder();
		
		clausula.append("1) El alquiler será abonado, por adelantado, del ");
		clausula.append(diaDesde);
		clausula.append("º al ");
		clausula.append(diaHasta);
		clausula.append("º día de cada mes a LA LOCADORA o a quién esta " +
				"designare, en el lugar del objeto locado, es decir en calle ");
		clausula.append(propiedad.getDireccion().getCalle());
		clausula.append(" Nº ");
		clausula.append(propiedad.getDireccion().getNumero());
		clausula.append(" Bº ");
		clausula.append(propiedad.getDireccion().getBarrios().getNombre());
		clausula.append(" de la Ciudad de ");
		clausula.append(propiedad.getDireccion().getBarrios().getLocalidad().
				getNombre());
		clausula.append(", o en cualquier otro lugar que se indicare en el " +
				"futuro. 2) El alquiler se pacta por períodos de mes entero, " +
				"por lo tanto si la parte LOCATARIA restituyera a la parte " +
				"LOCADORA la tenencia del inmueble antes del vencimiento de " +
				"un período mensual normal, igualmente deberá abonar " +
				"íntegramente dicho mes. 3) La mora se producirá de pleno " +
				"derecho y sin necesidad de interpelación judicial o " +
				"extrajudicial de ninguna naturaleza a partir de la fecha de " +
				"vencimiento (día 10 o hábil siguiente) del mes " +
				"correspondiente y hasta el día del efectivo pago. " +
				"Producida la mora la LOCATARIA deberá abonar además del " +
				"alquiler pactado una multa en concepto de intereses " +
				"moratorios del ");
		clausula.append(interes);
		clausula.append("% ");
		clausula.append(tipoInteres.toLowerCase());
		clausula.append(" sobre el importe adeudado durante el tiempo en el " +
				"que se encuentre en mora desde el primer día del mes.- 4) " +
				"La falta de pago de dos períodos de alquileres consecutivos " +
				"o alternados, dará derecho a la parte LOCADORA a promover " +
				"acción de desalojo, cobro de alquileres y demás rubros " +
				"convenidos en el presente, además de producir la resolución " +
				"del contrato de pleno derecho sin necesidad alguna de " +
				"interpelación judicial o extrajudicial, cuando el día 10 ó " +
				"el 1º día hábil siguiente del segundo mes no se haya " +
				"verificado el pago.- La falta de pago de un mes, dará " +
				"derecho a las acciones de cobro que correspondan, " +
				"especialmente el procedimiento de embargo preventivo " +
				"previsto por el art. 466 del Código Civil.-");
		
		return clausula.toString();
	}
	
	public static String getCondicionesInmueble(String color, String pintura, 
			String extras)
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("LA LOCATARIA declara y dice haber visitado y " +
				"recibido el inmueble locado desocupado y en perfectas " +
				"condiciones de habitabilidad, pintado color ");
		clausula.append(color);
		clausula.append(" con ");
		clausula.append(pintura);
		clausula.append(", interior y frente, obligándose a mantener y " +
				"devolver el mismo en idénticas condiciones y a abonar el " +
				"importe de los objetos que faltaren o estuvieren rotos y " +
				"los deterioros ocasionados, salvo aquellos que resultaren " +
				"del buen uso y la acción del tiempo.-");
		if (!extras.equals(""))
		{
			clausula.append("\n");
			clausula.append(extras);
		}	
		return clausula.toString();
	}
//Solo la prohibiciones que no son intransferibilidad	
	public static String getProhibiciones()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("LA LOCATARIA, bajo ningún concepto, podrá tener en " +
				"la propiedad cosas que pudiesen afectar la seguridad de las " +
				"personas, objetos e instalaciones, ni realizar actos que " +
				"contraríen las normas municipales vigentes.-");
		return clausula.toString();
	}

	public static String getIntransferibilidad()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("La LOCATARIA se obliga a no subarrendar el todo " +
				"parte de la propiedad, a no transferir, ni ceder el " +
				"presente contrato, so pena de rescindirse el mismo, " +
				"renunciando en este acto al art. 1853 del Código Civil.-");
		return clausula.toString();
	}
	
	public static String getGrupoFamiliar(EnteBean persona)
	{
		StringBuilder clienteString = new StringBuilder();
		ClienteBean cliente = (ClienteBean) persona;
		if (cliente.getSexo().equals("m"))
		{
			clienteString.append("El Sr. "); 
		}
		else
		{
			clienteString.append("La Sra. "); 
		}
		clienteString.append(cliente.getApellido().toUpperCase() + ", ");
		clienteString.append(cliente.getNombres().toUpperCase());
		
		StringBuilder clausula = new StringBuilder();
		clausula.append("La LOCATARIA ocupará el bien locado con destino a " +
				"vivienda familiar el que será ocupado por ");
		clausula.append(clienteString);
		clausula.append(" y sus familiares directos hasta el primer grado de " +
				"consanguinidad y no podrá cambiar su destino ni hacer " +
				"modificaciones de ninguna naturaleza en la propiedad sin " +
				"consentimiento previo y por manera fehaciente de la " +
				"LOCADORA y teniendo en cuenta que las mismas de cualquier " +
				"naturaleza que fueran, quedarán a beneficio de la propiedad " +
				"sin remuneración alguna.-");
		return clausula.toString();
	}
	
	public static String getImpuestosTasasServicios()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("a) El precio del alquiler está fijado en todo " +
				"concepto, por lo que LA LOCADORA tiene a su cargo el pago " +
				"de los impuestos que gravan al inmueble, PROVINCIALES " +
				"(D.G.R.) y MUNICIPALES.-  b) LA LOCATARIA tendrá a su " +
				"cargo el pago de los SERVICIOS de luz, agua, gas, teléfono " +
				"si lo hubiere, y otros que deseara contratar, para lo que " +
				"se obliga a contratar medidores a su nombre, en el lapso de " +
				"15 (quince) días hábiles a partir de la ocupación efectiva " +
				"del inmueble, y a presentar en forma mensual los servicios " +
				"pagados a La LOCADORA. c) LA LOCATARIA se obliga a partir " +
				"de la firma de este contrato a: a) dejar pagos y al día " +
				"todos los  servicios a su exclusivo cargo, de luz, gas, " +
				"cable, agua corriente, teléfono si lo hubiere a las " +
				"empresas respectivas y a abonar posteriormente dicho " +
				"suministro desde la fecha de inicio de la locación hasta el " +
				"reintegro del bien locado. A tal efecto cuenta con el plazo " +
				"de (15) quince días a partir de la entrega de la propiedad, " +
				"presentando los respectivos libre deudas. LA LOCADORA y/o " +
				"administrador no está obligado a recibir los alquileres " +
				"mientras no se acrediten los pagos de manos de la LOCATARIA " +
				"de servicios e impuestos tasas y contribuciones existentes " +
				"en la actualidad o que se crearan en el futuro, que graven " +
				"el bien locado sean estos normales, adicionales o de " +
				"emergencia, por ser estos parte integrante del alquiler " +
				"y deberán ser rendidos al propietario o a quien éste " +
				"designe mediante la entrega de los correspondientes " +
				"comprobantes; b) abonar las multas eventualmente pudieran " +
				"imponer las autoridades, Municipales, Provinciales o " +
				"Nacionales, por infracciones por parte de la LOCATARIA a " +
				"las ordenanzas y Leyes vigentes; c) arreglar por su cuenta " +
				"y cargo todo entorpecimiento a los servicios sanitarios,  " +
				"pluviales,  desagües cloacas, pozos negros, cámaras " +
				"sépticas, etc.; d) pagar en su debido término todos los " +
				"servicios de la propiedad de cualquier índole que sean, " +
				"como así también las tasas por servicios, recargos, " +
				"adicionales, impuestos extraordinarios o especiales, " +
				"debiendo exhibir el comprobante respectivo las veces que " +
				"le sea requerido. Asimismo en caso de que el pago hubiere " +
				"sido realizado por el propietario, se obliga a su reintegro " +
				"inmediato, como condición previa para el pago del alquiler; " +
				"e) a conservar el inmueble, plantas, espacios verdes y " +
				"demás elementos que configuran la propiedad, en perfecto " +
				"estado, durante todo el tiempo que la ocupe.-");
		
		return clausula.toString();
	}
	
	public static String getResponsabilidadesLocataria()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("LA LOCATARIA se compromete a dar cuenta a la " +
				"LOCADORA cualquier desperfecto que se produjera en el " +
				"inmueble y a la vez le permitirá al mismo el acceso a la " +
				"propiedad cuando éste lo juzgue necesario, al igual que a " +
				"personas que la LOCADORA designe para trabajos de arreglos " +
				"o mantenimiento, sin derecho a cobrar indemnización " +
				"alguna.- Asimismo manifiesta conocer y aceptar plenamente " +
				"las Ordenanzas y Reglamentaciones Municipales y " +
				"Provinciales sobre Policía Edilicia, obligándose a " +
				"respetarlas y acatar y saldar toda infracción a las mismas.-");
		return clausula.toString();
	}
	
	public static String getResponsabilidadesLocadora()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("La LOCADORA no se responsabiliza de los daños y " +
				"perjuicios que pudieran producirle a la LOCATARIA o a " +
				"cualquier persona que se encuentre en la propiedad, las " +
				"inundaciones, filtraciones y desprendimientos provenientes " +
				"de roturas o desperfectos de caños o techos o cualquier " +
				"otro accidente producido en la propiedad.-");
		return clausula.toString();
	}
	
	public static String getConsignacionLlaves()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("En caso de consignación de llaves, el alquiler " +
				"regirá hasta que la LOCADORA tome posesión real y efectiva " +
				"de la propiedad, en perfectas condiciones de habitabilidad, " +
				"libre de ocupantes y de cargas.-");
		return clausula.toString();
	}
	
	public static String getIncumplimientoDesalojo()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("Ante cualquier incumplimiento de las cláusulas del " +
				"presente contrato, LA LOCADORA queda facultada para pedir " +
				"el desalojo. LA LOCATARIA queda incursa en mora de forma " +
				"automática, sin necesidad de previa  intimación judicial o " +
				"extrajudicial, ello sin perjuicio de lo que dispone el art. " +
				"5 de la ley 23.091, por lo que la LOCADORA podrá: a) pedir " +
				"el cumplimiento del contrato judicialmente o b) solicitar " +
				"la rescisión del contrato por el ministerio de la ley, en " +
				"cuyo caso la LOCATARIA deberá desocupar inmediatamente el " +
				"inmueble, dejándolo libre de cosas y deudas que dependan de " +
				"él y en el mismo estado que lo recibió. En caso de mora en " +
				"la entrega del inmueble por parte de la LOCATARIA éste " +
				"deberá abonar una multa del 1% diario sobre el último " +
				"alquiler pagado, en concepto de daños y perjuicios por " +
				"cada día que demore la desocupación, sin perjuicio del pago " +
				"del alquiler correspondiente");
		return clausula.toString();
	}
	
	public static String getRescision()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("LA LOCATARIA podrá rescindir el presente contrato  " +
				"de locación, después de transcurrir los seis meses de " +
				"locación, debiendo avisar en forma fehaciente a la LOCADORA " +
				"con 60 días de anticipación. LA LOCATARIA, de hacer uso de " +
				"la acción resolutoria, deberá abonar a LA LOCADORA en " +
				"concepto de indemnización la suma equivalente a un mes y " +
				"medio de alquiler, si media entre los primeros seis  meses " +
				"y el año, y un mes después de dicho plazo, al momento de " +
				"desocupar el bien. Sólo se podrá hacer efectiva con" +
				" alquileres, impuestos y servicios al día.-");
		return clausula.toString();
	}
	
	public static String getSellados()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("Los gastos de sellados, informes, y honorarios del " +
				"presente contrato y los que devinieran de él serán " +
				"soportados por la LOCATARIA.-");
		return clausula.toString();
	}
	
	public static String getCostosYHonorarios()
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("Los costos y honorarios que resulten de las " +
				"acciones judiciales llevados a cabo para el cumplimiento de " +
				"las obligaciones derivadas del contrato, como su rescisión, " +
				"serán soportadas por la LOCATARIA y su garante, aún cuando " +
				"con la acción se persiga el desalojo. Estarán a su cargo " +
				"los gastos por acciones extrajudiciales que surjan del " +
				"contrato.-");
		return clausula.toString();
	}
	
	public static String getGarantes(List<GarantiaBean> garantes)
	{
		StringBuilder clausula = new StringBuilder();
		clausula.append("Se constituyen en garantes fiadores, llanos y " +
				"principales pagadores, en forma solidaria y mancomunada, " +
				"de todos los efectos y obligaciones del presente contrato, " +
				"inclusive las costas judiciales y hasta tanto el inmueble " +
				"sea entregado y desocupado de conformidad con LA LOCADORA, " +
				"en buen estado, sin deuda alguna, y demás pactado, " +
				"renunciando desde ya a los beneficios de excusión, " +
				"división, interpelación o aviso previo y a los demás que " +
				"la ley acuerde a los fiadores, respondiendo como tales sin " +
				"limitación alguna, ");
		boolean primero = true;
		boolean propietaria = false;
		for (GarantiaBean garantia : garantes)
		{
			if (primero)
			{
				 primero = false;
			}
			else
			{
				clausula.append("; ");
			}
			
			if (garantia.getGarante().getSexo().equals("m"))
			{
				clausula.append(" El Sr. "); 
			}
			else
			{
				clausula.append(" La Sra. "); 
			}
			clausula.append(
					garantia.getGarante().getApellido().toUpperCase() + 
					", " + garantia.getGarante().getNombres() + ", " +
					garantia.getGarante().getTipoDocumento().getTipo() +
					" N° " + garantia.getGarante().getNumeroDocumento() + 
			", con domicilio en ");
			DireccionBean direccion = null;
			for (DireccionBean dir : garantia.getGarante().getDirecciones())
			{
				if (dir.getTipoUbicacion().getNombre().
						equals("Particular"))
				{
					direccion = dir;
				}
			}
			if (direccion == null)
			{
				direccion = garantia.getGarante().getDirecciones()[0];
			}
			clausula.append(direccion.getCalle() + " N° " +
					direccion.getNumero() + " B° " +
					direccion.getBarrios().getNombre() + 
					" de la ciudad de " +
					direccion.getBarrios().getNombreLocalidad() + 
					", Provincia de " +
					direccion.getBarrios().getNombreProvincia());
			if (garantia.getTipoGarantia() == TipoGarantia.SUELDO)
			{
				clausula.append(", quien presenta Recibo de haberes de ");
				clausula.append(garantia.getDescripcionGarantia());	
			} 
			else {
				propietaria = true;
				clausula.append(", quien presenta en garantía una propiedad " +
						"sito en ");
				clausula.append(garantia.getDescripcionGarantia());
			}	
		}
		if (propietaria)
		{
			clausula.append(".\nse deja constancia que el/los firmante/s " +
					"hace/n expresa renuncia en este acto al beneficio de " +
					"inembargabilidad de la propiedad que afectan a " +
					"dicho efecto en este contrato de Locación. La razón " +
					"de la RENUNCIA obedece a la decisión de " +
					"constituirse en GARANTE, solidario, liso, llano y " +
					"principal pagador sobre todas las obligaciones " +
					"emergentes de este contrato de Locación, " +
					"correspondiente al derecho establecido por la Ley " +
					"Nacional 14.394 como así también el Art.58 de la " +
					"Constitución Provincial, Ley 8067 (Inembargabilidad " +
					"de la vivienda única), firmando  ante Escribano " +
					"Público, la cual se encuentra libre de gravámenes y " +
					"desafectada como bien de familia");	
		}
		clausula.append(".\nLa LOCADORA podrá dirigir su acción en caso de " +
				"incumplimiento o diferendo contra cualquiera de los " +
				"firmantes de este contrato de locación.-");
		return clausula.toString();
	}
	
	public static String getReemplazoGarantes()
	{
		StringBuilder clausula = new StringBuilder();
		
		clausula.append("En caso de falencia, insolvencia, fallecimiento, " +
				"desaparición, irresponsabilidad manifiesta  etc., " +
				"del o de los fiadores, el LOCADOR podrá requerir un nuevo " +
				"garante fiador, en el término de 5 (cinco días corridos ), " +
				"cuya solvencia no podrá ser inferior al  anterior, quedando " +
				"ésta a juicio y satisfacción de el LOCADOR. En caso de " +
				"incumplimiento de esta obligación por parte del LOCATARIO, " +
				"quedará rescindido el contrato, como si el convenio fuese " +
				"el término vencido. El garante fiador se obliga a comunicar " +
				"cualquier disminución que sufra la garantía, y se obliga " +
				"mantener la garantía libre de gravámenes y deudas, quedando " +
				"expresamente prohibido cualquier acto en contrario por el " +
				"garante, se presumirá doloso y dará lugar a la rescisión " +
				"del contrato y desocupación del inmueble, sin perjuicio de " +
				"las acciones legales, civiles o penales a que tenga derecho " +
				"el LOCADOR. El garante afecta directamente y como un " +
				"respaldo más al fiel cumplimiento de la garantía a su " +
				"cargo, el bien de su propiedad que a continuación se indica " +
				"y que el LOCADOR ha aceptado como garantía.-");
		
		return clausula.toString();
	}
	
	public static String getDomicilios()
	{
		StringBuilder clausula = new StringBuilder();
		
		return clausula.toString();
	}
	
	public static String getJurisdiccion()
	{
		StringBuilder clausula = new StringBuilder();
		
		return clausula.toString();
	}
}
