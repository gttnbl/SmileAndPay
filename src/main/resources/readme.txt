#################################################################### info projet ########################################
tous les api sont develop�s en REST ,malheuresement j'ai pas eu le temps pour developper le SOAP(je partirai en vacances)

################################################### DATABASE ###################################################
1) Dans spring-servlet.xml vous trouverez la config BD 
		
		url: jdbc:postgresql://localhost:5432/SandP
		username" value="postgres" 
		password" value="admin" 
2) script.sql sous src/main/resources contient la structure des tables (meme si vous le lancez pas ,Hibernate fait le job ;) )

################################################### ENDPOINT ###################################################

1) MarchantController

   - /getMarchant : get Marchant par un id
   - /updateMarchant update un marchant existant
   - /addMarchant ajouter un nouveau marchant
   - /deleteMarchant : delete un marchant s'il existe
   - /getAllMarchants afficher la liste des marchants
   
2) ProductController

    - /getProduct : get Product par un id
    - /updateProduct update un Product existant
    - /addProduct ajouter un nouveau Product
    - /deleteProduct : delete un Product s'il existe
    - /getAllProducts afficher la liste des Products
    - /associateMarchant : affecter un product � un marchant
	
	NB: pour la la delete j'ai mis  CascadeType.REMOVE que dans la cot� de product,pas de cot� marchant (c'est pas une faute ,just pour tester les deux scenarios :D ) 
	  ==> si on fait deleteProduct � un product qui est attch� � un marchant la suppression se fait correctement et il supprime l'association dans la table marchant_product
	  ==> si on fait deleteMarchant � un marchant qui est attch� � un product la suppression ne se fait pas car ce marchant est attach� � un product dans la table marchant_product


########################################################### Test ####################################################
des Unit tests sont implement�s avec une couverture qui d�passe 90%
vous trouvez en PJ un projet postman avec les differents test des endpoints (src/main/resources)

#####################################Partie SOAP##########################################
Vous trouvrez la config des endpoints dans le fichier : /SmileAndPay/WebContent/WEB-INF/sun-jaxws.xml
1) MarchantService: pour les WS Marchant : http://localhost:8081/SmileAndPay/services/MarchantService?wsdl
2) ProductService:  pour les WS Product : http://localhost:8081/SmileAndPay/services/ProductService?wsdl


Vous trouvez un projet SOAP-UI qui contient des tests sur les endpoints sous :/SmileAndPay/src/main/resources/
#####################################github repository##########################################

https://github.com/gttnbl/SmileAndPay.git