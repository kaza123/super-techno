(function () {
    angular.module("AppModule")
            .controller("mainController", function ($scope, $filter, $uibModalStack, $uibModal, $rootScope, $cookieStore, Factory, $location, Notification) {
                $scope.model = {};
                $scope.model.data = {};
                $scope.model.popupData = {};

                $scope.ui = {};
                $scope.mainG = {};

                $scope.model.urlACustomer = '/api/sv/auto/customer';
                $scope.model.urlSCustomer = '/api/sv/super/customer';
                $scope.model.urlAVehicle = '/api/sv/auto/vehicle';
                $scope.model.urlSVehicle = '/api/sv/super/vehicle';
                $scope.model.urlAJobDetail = '/api/sv/auto/job-detail/';
                $scope.model.urlSJobDetail = '/api/sv/super/job-detail/';
                $scope.model.urlASave = '/api/sv/auto/save-job-detail';
                $scope.model.urlSSave = '/api/sv/super/save-job-detail';

                $scope.ui.customerList = [];
                $scope.ui.vehicleList = [];
                $scope.ui.detailList = [];

                $scope.customerList = function (url) {
                    Factory.findAll(url,
                            function (data) {
                                if (data) {
                                    $scope.ui.customerList = data;
                                }
                            },
                            function () {
                            }
                    );
                };
                $scope.vehicleList = function (url) {
                    Factory.findAll(url,
                            function (data) {
                                if (data) {
                                    $scope.ui.vehicleList = data;
                                }
                            },
                            function () {
                            }
                    );
                };
                $scope.ui.customerLable = function (index) {
                    var lable = "";
                    angular.forEach($scope.ui.customerList, function (customer) {
                        if (customer.cusNo === index) {
                            lable = customer.cusName + ' - ' + customer.mobNo;
                            return;
                        }
                    });
                    return lable;
                };

                $scope.ui.vehicleLable = function (index) {
                    var lable = "";
                    angular.forEach($scope.ui.vehicleList, function (vehicle) {
                        if (vehicle.jobNo === index) {
                            lable = vehicle.vehNo + ' - ' + vehicle.jobNo;
                            $scope.model.data.customer = vehicle.cusNo;
                            $scope.model.data.model = vehicle.vmake + ' - ' + vehicle.vmodel;
                            $scope.ui.search(index);
                            return;
                        }
                    });
                    return lable;
                };
                $scope.ui.search = function (jobNo) {
                    var url = "";
                    if ($scope.mainG.currentUser.branch === 1) {
                        url = $scope.model.urlSJobDetail;
                    } else if ($scope.mainG.currentUser.branch === 2) {
                        url = $scope.model.urlAJobDetail;

                    } else {
                        Notification.error('cant find branch');
                        return;
                    }
                    Factory.findAll(url + jobNo,
                            function (data) {
                                if (data) {
                                    $scope.ui.detailList = data;
                                    console.log(data);
                                }
                            },
                            function () {
                            }
                    );
                };
                $scope.ui.check = function (date) {
                    if (parseInt(date) <= 2) {
                        return true;
                    }
                    return false;
                };
                $scope.ui.bolt = function (date) {
                    if (parseInt(date) > 2) {
                        return true;
                    }
                    return false;
                };
                $scope.ui.popup = function (detail) {
                    if (detail.isAdminUpdate && $scope.mainG.currentUser.type === 'editor') {
                        Notification.error('Admin Already Approved !');

                    } else {
                        $scope.model.popupData = detail;
                        $scope.ui.unitPriceChange();
                        $scope.ui.discountChange();
                        $uibModal.open({
                            animation: true,
                            ariaLabelledBy: 'modal-title',
                            ariaDescribedBy: 'modal-body',
                            templateUrl: 'popup.html',
                            scope: $scope,
                            size: 'lg'
                        });

                    }
                };

                $scope.ui.modelCancel = function () {
                    $uibModalStack.dismissAll();
                };
                $scope.ui.save = function () {
                    var check = true;
                    console.log($scope.model.popupData);

                    if ($scope.mainG.currentUser.type === 'admin') {
                        $scope.model.popupData.adminDate = $filter('date')(new Date(), "yyyy-MM-dd HH:mm:ss");
                        $scope.model.popupData.isAdminUpdate = 1;
                        $scope.model.popupData.val = $scope.model.popupData.uprice * $scope.model.popupData.qty;
                    }
                    if ($scope.mainG.currentUser.type === 'editor') {
                        console.log("editor " + $scope.model.popupData.isAdminUpdate);
                        if ($scope.model.popupData.isAdminUpdate === "1") {
                            console.log("$scope.mainG.currentUser.isAdminUpdate " + $scope.mainG.currentUser.isAdminUpdate);
                            check = false;
                            Notification.error('You have no permission. This detail updated by admin !');

                        }
                        $scope.model.popupData.loginUser = $scope.mainG.currentUser.branch;
                        $scope.model.popupData.isUserUpdate = 1;
                        $scope.model.popupData.userDate = $filter('date')(new Date(), "yyyy-MM-dd HH:mm:ss");
                    }
                    if ($scope.mainG.currentUser.type === 'user') {
                        check = false;
                        Notification.error('You have no permission to save detail !');
                    }
                    var saveUrl = "";
                    console.log('$scope.mainG.currentUser.branch ' + $scope.mainG.currentUser.branch);
                    if ($scope.mainG.currentUser.branch === 1) {
                        saveUrl = $scope.model.urlSSave;
                    } else if ($scope.mainG.currentUser.branch === 2) {
                        saveUrl = $scope.model.urlASave;
                    } else {
                        Notification.error('Cant find Branch !');
                        check = false;

                    }
                    if (check) {
                        var detail = $scope.model.popupData;
                        var detailJSON = JSON.stringify(detail);
                        Factory.save(saveUrl, detailJSON,
                                function (data) {
                                    Notification.success("Detail save success !");
                                },
                                function (data) {
                                    console.log(data);
                                    Notification.error(data.message);
                                }
                        );

                    } else {

                    }

                    $scope.ui.modelCancel();

                };
                $scope.ui.unitPriceChange = function () {
                    $scope.model.popupData.value = $scope.model.popupData.purchasePrice * $scope.model.popupData.qty;
                    $scope.model.popupData.total = $scope.model.popupData.value - ($scope.model.popupData.value * $scope.model.popupData.purchaseDiscount / 100);
                };
                $scope.ui.discountChange = function () {
                    $scope.model.popupData.value = $scope.model.popupData.purchasePrice * $scope.model.popupData.qty;
                    $scope.model.popupData.total = $scope.model.popupData.value - ($scope.model.popupData.value * $scope.model.popupData.purchaseDiscount / 100);
                };

                $scope.ui.init = function () {
                    $scope.mainG = $cookieStore.get('globals');
                    console.log($scope.mainG);

                    if ($scope.mainG.currentUser.branch === 1) {
                        $scope.customerList($scope.model.urlSCustomer);
                        $scope.vehicleList($scope.model.urlSVehicle);

                    } else if ($scope.mainG.currentUser.branch === 2) {
                        $scope.customerList($scope.model.urlACustomer);
                        $scope.vehicleList($scope.model.urlAVehicle);

                    } else {
                        Notification.error('Cant find branch !');
                        $location.path('/');
                    }
                };
                $scope.ui.init();
            });
}());



