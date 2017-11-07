// This is the ANGULAR JS controller to consume the REST services written by us in in Cart_Controller

var cartApp = angular.module("cartApp",[]); // this is module - shud match wid name as in cart.jsp
		//	[] indicates this module has no dependency on any other module, otherwise we may gv that module name within []

cartApp.controller("cartCtrl" , function($scope, $http){ // scope & http are pre-defined services
		// $scope is basically the glue between view and controller,
		// It can be said to be the ModelAndView as per java lang

	// this url is mapped to cart_controller.java's read method (note - $http.get)
	$scope.refreshCart = function(cartId){ 
		console.log("hello there, inside refresh !");
		$http.get('/MusicShop/rest/cart/'+$scope.cartId).success(function(data){ 
			$scope.cart = data;		//	'/MusicShop/rest/cart' + $scope.cartId) -> this part gets the cart data in JSON format
			console.log("$scope.cart ---> " + $scope.cart.cartId);
		}); 						//	If its succes, then this data is stored as 'data' and then passed to scope.cart
	};
	
	$scope.clearCart = function(){
		//$http.delete('/MusicShop/rest/cart/' + $scope.cartId).success($scope.refreshCart($scope.cartId)); // $scope.refreshCart($scope.cartId) -> this is basically calling the refresh funcn defined earlier passing the cartId
		$http['delete']('/MusicShop/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId)); // only bcoz $http.delete is not understood by Eclipse
	};
	
	$scope.initCartId = function(cartId){
		console.log("hello there, inside init !");
		$scope.cartId = cartId;
		$scope.refreshCart(cartId); // We are using the refresh cart function to initialize the cart	
	};
	
    $scope.addToCart = function(prod_id) {	
        $http.put('/MusicShop/rest/cart/add/'+prod_id).success(function(data) {  // if success, refresh the cart again
        	console.log("here 1 ");            	
        	$scope.refreshCart($http.get('/MusicShop/rest/cart/cartId')); // tried with both this and the next line
        	//$scope.refreshCart($http.get('/MusicShop/rest/cart/' + $scope.cartId));
        	//$scope.refreshCart($scope.cartId);
        	console.log("here 2");
            alert("Product successfully added to the cart!");
        });
    };

    $scope.removeFromCart = function(prod_id) {
        $http.put('/MusicShop/rest/cart/remove/'+prod_id).success(function(data) {
            $scope.refreshCart($http.get('/MusicShop/rest/cart/cartId'));
        });
    };
    
    /*
    $scope.calGrandTotal = function () {
        var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    };
    */
});
