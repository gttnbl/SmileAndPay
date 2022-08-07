# SmileAndPay

######################## info projet ###############  <br/> tous les api sont developés en REST ,malheuresement j'ai pas eu le temps pour developper le SOAP(je partirai en vacances)



######################### DATABASE ####################### <br/>
1) Dans spring-servlet.xml vous trouverez la config BD 
		
		url: jdbc:postgresql://localhost:5432/SandP
		username" value="postgres" 
		password" value="admin" 
2) script.sql sous src/main/resources contient la structure des tables (meme si vous le lancez pas ,Hibernate fait le job ;) )

############################ ENDPOINT ########################### <br/>

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
    - /associateMarchant : affecter un product à un marchant
	
	NB: pour la la delete j'ai mis  CascadeType.REMOVE que dans la coté de product,pas de coté marchant (c'est pas une faute ,just pour tester les deux scenarios :D ) 
	  ==> si on fait deleteProduct à un product qui est attché à un marchant la suppression se fait correctement et il supprime l'association dans la table marchant_product
	  ==> si on fait deleteMarchant à un marchant qui est attché à un product la suppression ne se fait pas car ce marchant est attaché à un product dans la table marchant_product


################################## Test ########################## <br/>
des Unit tests sont implementés avec une couverture qui dépasse 90%
vous trouvez en PJ un projet postman avec les differents test des endpoints (src/main/resources) :SmileAndPay.postman_collection.json


#####################################github repository########################################## <br/>

https://github.com/gttnbl/SmileAndPay.git
