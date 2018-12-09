<!-- Header Start -->
    <header>
      <a href="index.html" class="logo">
        <c:url var="logopng" value="images/dockpage/logo.png" />
        <img src="<c:url value='${logopng}'/>" alt="Logo a"/>
        <!-- This kind is also ok -->
        <%-- <img src="${pageContext.request.contextPath}/images/dockpage/logo.png" alt="Logo"/> --%>
      </a>
      <div class="pull-right">
        <ul id="mini-nav" class="clearfix">
          <li class="list-box hidden-xs">
            <a href="#" data-toggle="modal" data-target="#modalMd">
              <span class="text-white">Code</span> <i class="fa fa-code"></i>
            </a>
            <!-- Modal -->
            <div class="modal fade" id="modalMd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel5" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title text-danger" id="myModalLabel5">Coding Style </h4>
                  </div>
                  <div class="modal-body">
                    <springform:form method="post" action="${pageContext.request.contextPath}/addRole" modelAttribute="user">
					     <table>
					        <tr>
					            <td>User Name:</td>
					            <td><input type="text" name="name"/><springform:errors delimiter="," path="name"></springform:errors></td>
					        </tr>
					         <tr>
					            <td>remark:</td>
					            <td><input type="text" name="remark"/><springform:errors delimiter="," path="remark"></springform:errors></td>
					        </tr>
					        <tr>
                                <td>sex: </td>
                                <td><input type="text" name="sex"/><springform:errors delimiter="," path="sex"></springform:errors></td>
                            </tr> 
					        <tr>
					        <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
					            <td colspan="2"> <input type="submit" value="提交"/> </td>
					        </tr>
					     </table>
					</springform:form>
					
					 <form method="post" action="${pageContext.request.contextPath}/addRole">
                         <table>
                            <tr>
                                <td>User Name:</td>
                                <td><input type="text" name="name"/></td>
                            </tr>
                             <tr>
                                <td>remark:</td>
                                <td><input type="text" name="remark"/></td>
                            </tr>
                            <tr>
                                <td>sex: </td>
                                <td><input type="text" name="sex"/></td>
                            </tr> 
                            <tr>
                                <td colspan="2"> <input type="submit" value="submit"/> </td>
                            </tr>
                         </table>
                    </form>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> CloseY</button>
                  </div>
                </div>
              </div>
            </div>
          </li>
          <li class="list-box dropdown">
            <a id="drop5" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-film"></i>
            </a>
            <span class="info-label info-bg">9+</span>
            <ul class="dropdown-menu stats-widget clearfix">
              <li>
                <h5 class="text-success">$37895</h5>
                <p>Revenue <span class="text-success">+2%</span></p>
                <div class="progress progress-mini">
                  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                    <span class="sr-only">40% Complete (success)</span>
                  </div>
                </div>
              </li>
              <li>
                <h5 class="text-warning">47,892</h5>
                <p>Downloads <span class="text-warning">+39%</span></p>
                <div class="progress progress-mini">
                  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                    <span class="sr-only">40% Complete (warning)</span>
                  </div>
                </div>
              </li>
              <li>
                <h5 class="text-danger">28214</h5>
                <p>Uploads <span class="text-danger">-7%</span></p>
                <div class="progress progress-mini">
                  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                    <span class="sr-only">40% Complete (danger)</span>
                  </div>
                </div>
              </li>
            </ul>
          </li>
          <li class="list-box dropdown">
            <a id="drop5" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-calendar"></i>
            </a>
            <span class="info-label success-bg">6</span>
            <ul class="dropdown-menu server-activity">
              <li>
                <p><i class="fa fa-flag text-info"></i> Pending request<span class="time">3 hrs</span></p>
              </li>
              <li>
                <p><i class="fa fa-fire text-warning"></i> Server Crashed<span class="time">3mins</span></p>
              </li>
              <li>
                <p><i class="fa fa-user text-success"></i> 3 New users<span class="time">1 min</span></p>
              </li>
              <li>
                <p><i class="fa fa-bell text-danger"></i>9 pending requests<span class="time">5 min</span></p>
              </li>
              <li>
                <p><i class="fa fa-plane text-info"></i> Performance<span class="time">25 min</span></p>
              </li>
              <li>
                <p><i class="fa fa-envelope text-warning"></i>12 new emails<span class="time">25 min</span></p>
              </li>
              <li>
                <p><i class="fa fa-cog icon-spin text-success"></i> Location settings<span class="time">4 hrs</span></p>
              </li>
            </ul>
          </li>
          <li class="list-box user-profile">
            <a id="drop7" href="#" role="button" class="dropdown-toggle user-avtar" data-toggle="dropdown">
              <c:url var="user5bl" value="images/dockpage/user5.png" />
              <img src="<c:url value='${user5bl}'/>" alt="Bluemoon User">
            </a>
            <ul class="dropdown-menu server-activity">
              <li>
                <p><i class="fa fa-cog text-info"></i> Account Settings</p>
              </li>
              <li>
                <p><i class="fa fa-fire text-warning"></i> Payment Details</p>
              </li>
              <li>
                <div class="demo-btn-group clearfix">
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-facebook fa-lg icon-rounded info-bg"></i>
                  </a>
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-twitter fa-lg icon-rounded twitter-bg"></i>
                  </a>
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-linkedin fa-lg icon-rounded linkedin-bg"></i>
                  </a>
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-pinterest fa-lg icon-rounded danger-bg"></i>
                  </a>
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-google-plus fa-lg icon-rounded success-bg"></i>
                  </a>
                </div>
              </li>
              <li>
              <!-- Docking page. All of logic business from here. -->
                    <c:url var="logoutUrl" value="/logout" />
                    <form id="form1" action="${logoutUrl}" method="post">
	                    <button href="#"  class="btn btn-danger">
	                       Logout
	                    </button>
                        <!-- <a href="javascript:;" onclick="update();"> Log Out</a>  --><input
                            type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
                <!-- <div class="demo-btn-group clearfix">                    
                  <button href="#" class="btn btn-danger">
                    Logout
                  </button>
                </div> -->
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </header>
    <!-- Header End -->