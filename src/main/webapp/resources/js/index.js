
        
    function esconder() {
        
        document.getElementById('myMap').style.display = 'none';
        document.getElementById('contatos').style.display = 'none';
        document.getElementById('tabela').style.display = 'none';
        document.getElementById('telefone').style.display = 'none';
    }
    
    function tabela() {
        document.getElementById('tabela').style.display = 'block';
        document.getElementById('contatos').style.display = 'none';
        document.getElementById('myMap').style.display = 'none';
        document.getElementById('telefone').style.display = 'none';
    }
    
    function contatos() {
        document.getElementById('contatos').style.display = 'block';
        document.getElementById('tabela').style.display = 'none';
        document.getElementById('myMap').style.display = 'none';
        document.getElementById('telefone').style.display = 'none';
    }
    
    function cadastroTel() {
        document.getElementById('telefone').style.display = 'block';
        document.getElementById('tabela').style.display = 'none';
        document.getElementById('myMap').style.display = 'none';
        document.getElementById('contatos').style.display = 'none';
    }
   
    function validar() {
        
    }
   
   
                function loadMapScenario() {
                    
                    document.getElementById('myMap').style.display = 'block';
                    
                    var map = new Microsoft.Maps.Map(document.getElementById('myMap'), {center: new Microsoft.Maps.Location(-8.0791787, -34.9051573)});
                    Microsoft.Maps.loadModule('Microsoft.Maps.DrawingTools', function () {
                        var tools = new Microsoft.Maps.DrawingTools(map);
                        tools.showDrawingManager(function (manager) {
                            printText('Drawing manager loaded.');
                            Microsoft.Maps.Events.addHandler(manager, 'drawingStarted', function () { printText('Drawing started.'); });
                            Microsoft.Maps.Events.addHandler(manager, 'drawingEnded', function () { printText('Drawing ended.'); });
                            Microsoft.Maps.Events.addHandler(manager, 'drawingErased', function () { printText('Drawing erased.'); });
                        });
                    });

                    Microsoft.Maps.Events.addHandler(map, 'rightclick', function (e) { 
                        
                        var point = new Microsoft.Maps.Point(e.getX(), e.getY());
                        var location = e.target.tryPixelToLocation(point);
                        
                        //alert(location.longitude+"       "+location.latitude);
                    
                        var xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function() {
                            if (this.readyState == 4 && this.status == 200) {
                                var myObj = JSON.parse(this.responseText);
                              
                                //document.getElementById('nomeocorrencia').value = myObj.display_name;
                                
                                var num = myObj.address.house_number;
                                if(num > 0) {
                                    document.getElementById('numero').innerHTML = "Numero: "+num;
                                    document.getElementById('numero1').value = num;
                                }
                                else {
                                    document.getElementById('numero').innerHTML = "Numero: sem numero";
                                    document.getElementById('numero1').value = "sem numero";
                                }
                                                                                                
                                document.getElementById('lat').value = location.latitude;
                                document.getElementById('long').value = location.longitude;
                                document.getElementById('cidade').innerHTML = "Cidade: "+myObj.address.city;
                                document.getElementById('cidade1').value = myObj.address.city;
                                document.getElementById('bairro').innerHTML = "Bairro: "+myObj.address.suburb;
                                document.getElementById('bairro1').value = myObj.address.suburb;
                                document.getElementById('rua').innerHTML = myObj.address.road;
                                document.getElementById('rua1').value = myObj.address.road;
                                document.getElementById('CEP').innerHTML = "CEP: "+myObj.address.postcode;
                                document.getElementById('CEP1').value = myObj.address.postcode;
                                
                                    PF('dlg').show();
                                    
                                }
                                else (this.status);
                        };
                                xhttp.open("GET", "https://nominatim.openstreetmap.org/reverse?format=json&lat="+location.latitude+"&lon="+location.longitude+"");
                                xhttp.send();
                    });
                    
                }
            
    
    onload = esconder;
             