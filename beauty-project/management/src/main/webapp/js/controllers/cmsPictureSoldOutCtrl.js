angular.module('controllers',[]).controller('cmsPictureSoldOutCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','GetBanner',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,GetBanner) {


            $scope.id = $stateParams.id;

            GetBanner.get({bannerResourceID:$scope.id},function(data){
                console.log(data)
                $scope.response = data.responseData;
            })
















            //删除
            $scope.delFun = function(id){
                // DelMember.get({id:id},function(data){
                //     if(data.result == Global.SUCCESS){
                $scope.alertInfo = false;
                // $scope.loadPageList();
                // }
                // })
            }


        }])