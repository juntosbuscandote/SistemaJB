                                         <div class="x_panel">
                                               <div class="" role="tabpanel" data-example-id="togglable-tabs"> 
      
                                                <div class="form-group">
                                                    <form method="GET" id="frm_filtrarCliente" name="frm_filtrarCliente" action="" novalidate>
													<div class="form-group">
														<label class="control-label col-md-1 col-sm-1 col-xs-12">Cliente:
														</label>
														<div class="col-md-2 col-sm-2 col-xs-12">
															<select style="width: 100%" class="form-control select2-single" tabindex="-1" aria-hidden="true" id="filtrarClienteNroC" name="filtrarClienteNroC"> 
																<c:forEach items="${filtrarClienteNroC}" var="filtrarClienteNros"> 
																<option selected="selected" attr-user2="${filtrarClienteNros.persVnumdoc}" 
																value="${filtrarClienteNros.clieBident}">${filtrarClienteNros.persVnumdoc}</option>
																</c:forEach>
															</select>

														</div>
														<label class="control-label col-md-1 col-sm-1 col-xs-12">Nombre:
														</label>
														<div class="col-md-8 col-sm-2 col-xs-12"><input class="form-control" id="filtrarClienteRazonSocialCliente" 
															name="filtrarClienteRazonSocialCliente" type="text">
														</div>
														<br>
														<br> 
														<label class="control-label col-md-1 col-sm-1 col-xs-12">Descripcion:
														</label>
														<div class="col-md-11 col-sm-2 col-xs-12">
															<input class="form-control"
																id="filtrarClienteDireccion"
																name="filtrarClienteDireccion" type="text">
														</div>
												</form>
												
											</div>
									</div>
							</div>
												
												
												
												
												
												