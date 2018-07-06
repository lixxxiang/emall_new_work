package com.android.lixiang.homepage.presenter.data.bean

class HomePageSlideBean {

    /**
     * data : [{"dataType":"110","imageUrl":"http://202.111.178.10:28085/upload/image/201805141734000027615_image.png"},{"dataType":"3","imageUrl":"http://202.111.178.10:28085/upload/image/201801161107000368706_image.png","link":"index.html"},{"dataType":"3","imageUrl":"http://202.111.178.10:28085/upload/image/201712110916000406400_image.png","link":"masterIndex.html?status=1"},{"dataType":"3","imageUrl":"http://202.111.178.10:28085/upload/image/201712051139000387758_image.png","link":"orderData.html","productId":"JL103B_MSS_20171006162735_100002453_101_001_L1B_MSS"},{"dataType":"3","imageUrl":"http://202.111.178.10:28085/upload/image/201712051132000457001_image.png","link":"masterIndex.html?status=2","productId":"JL101A_PMS_20170101164550_000017266_204_0013_001_L1_PAN"},{"dataType":"3","imageUrl":"http://202.111.178.10:28085/upload/image/201711222300000097689_image.png","link":"http://mall.charmingglobe.com/"}]
     * message : success
     * status : 200
     */

    var message: String? = null
    var status: Int = 0
    var data: List<DataBean>? = null

    class DataBean {
        /**
         * dataType : 110
         * imageUrl : http://202.111.178.10:28085/upload/image/201805141734000027615_image.png
         * link : index.html
         * productId : JL103B_MSS_20171006162735_100002453_101_001_L1B_MSS
         */

        var dataType: String? = null
        var imageUrl: String? = null
        var link: String? = null
        var productId: String? = null
    }
}
