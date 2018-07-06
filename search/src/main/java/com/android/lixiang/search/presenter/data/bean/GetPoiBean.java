package com.android.lixiang.search.presenter.data.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetPoiBean {


    private String type;
    private GdPoisBean gdPois;
    private ImagesBean images;
    private VideosBean videos;
    private ThematicsBean thematics;
    private String multiPoints;
    private ToolsBean tools;
    private List<SugBean> sug;

    public static GetPoiBean objectFromData(String str) {

        return new Gson().fromJson(str, GetPoiBean.class);
    }

    public static GetPoiBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetPoiBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetPoiBean> arrayGetPoiBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetPoiBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetPoiBean> arrayGetPoiBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetPoiBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GdPoisBean getGdPois() {
        return gdPois;
    }

    public void setGdPois(GdPoisBean gdPois) {
        this.gdPois = gdPois;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public VideosBean getVideos() {
        return videos;
    }

    public void setVideos(VideosBean videos) {
        this.videos = videos;
    }

    public ThematicsBean getThematics() {
        return thematics;
    }

    public void setThematics(ThematicsBean thematics) {
        this.thematics = thematics;
    }

    public String getMultiPoints() {
        return multiPoints;
    }

    public void setMultiPoints(String multiPoints) {
        this.multiPoints = multiPoints;
    }

    public ToolsBean getTools() {
        return tools;
    }

    public void setTools(ToolsBean tools) {
        this.tools = tools;
    }

    public List<SugBean> getSug() {
        return sug;
    }

    public void setSug(List<SugBean> sug) {
        this.sug = sug;
    }

    public static class GdPoisBean {
        @Override
        public String toString() {
            return "GdPoisBean{" +
                    "poiNum=" + poiNum +
                    ", poiList=" + poiList +
                    '}';
        }

        private int poiNum;
        private List<PoiListBean> poiList;

        public static GdPoisBean objectFromData(String str) {

            return new Gson().fromJson(str, GdPoisBean.class);
        }

        public static GdPoisBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), GdPoisBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<GdPoisBean> arrayGdPoisBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<GdPoisBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<GdPoisBean> arrayGdPoisBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<GdPoisBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getPoiNum() {
            return poiNum;
        }

        public void setPoiNum(int poiNum) {
            this.poiNum = poiNum;
        }

        public List<PoiListBean> getPoiList() {
            return poiList;
        }

        public void setPoiList(List<PoiListBean> poiList) {
            this.poiList = poiList;
        }

        public static class PoiListBean {
            private String id;
            private String name;
            private String pname;
            private String cityname;
            private String adname;
            private String address;
            private String location;
            private String type;

            public static PoiListBean objectFromData(String str) {

                return new Gson().fromJson(str, PoiListBean.class);
            }

            public static PoiListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), PoiListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<PoiListBean> arrayPoiListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<PoiListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<PoiListBean> arrayPoiListBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<PoiListBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPname() {
                return pname;
            }

            public void setPname(String pname) {
                this.pname = pname;
            }

            public String getCityname() {
                return cityname;
            }

            public void setCityname(String cityname) {
                this.cityname = cityname;
            }

            public String getAdname() {
                return adname;
            }

            public void setAdname(String adname) {
                this.adname = adname;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }

    public static class ImagesBean {
        private int imageNum;
        private List<ImageListBean> imageList;

        public static ImagesBean objectFromData(String str) {

            return new Gson().fromJson(str, ImagesBean.class);
        }

        public static ImagesBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ImagesBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ImagesBean> arrayImagesBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ImagesBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ImagesBean> arrayImagesBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ImagesBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getImageNum() {
            return imageNum;
        }

        public void setImageNum(int imageNum) {
            this.imageNum = imageNum;
        }

        public List<ImageListBean> getImageList() {
            return imageList;
        }

        public void setImageList(List<ImageListBean> imageList) {
            this.imageList = imageList;
        }

        public static class ImageListBean {
            private double imageArea;
            private int imageId;
            private String name;
            private String resolution;
            private String captureTime;
            private String img;

            public static ImageListBean objectFromData(String str) {

                return new Gson().fromJson(str, ImageListBean.class);
            }

            public static ImageListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ImageListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ImageListBean> arrayImageListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ImageListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ImageListBean> arrayImageListBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ImageListBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public double getImageArea() {
                return imageArea;
            }

            public void setImageArea(double imageArea) {
                this.imageArea = imageArea;
            }

            public int getImageId() {
                return imageId;
            }

            public void setImageId(int imageId) {
                this.imageId = imageId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getResolution() {
                return resolution;
            }

            public void setResolution(String resolution) {
                this.resolution = resolution;
            }

            public String getCaptureTime() {
                return captureTime;
            }

            public void setCaptureTime(String captureTime) {
                this.captureTime = captureTime;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }

    public static class VideosBean {
        private int videoNum;
        private List<?> videoList;

        public static VideosBean objectFromData(String str) {

            return new Gson().fromJson(str, VideosBean.class);
        }

        public static VideosBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), VideosBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<VideosBean> arrayVideosBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<VideosBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<VideosBean> arrayVideosBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<VideosBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getVideoNum() {
            return videoNum;
        }

        public void setVideoNum(int videoNum) {
            this.videoNum = videoNum;
        }

        public List<?> getVideoList() {
            return videoList;
        }

        public void setVideoList(List<?> videoList) {
            this.videoList = videoList;
        }
    }

    public static class ThematicsBean {
        private int thematicNum;
        private List<ThematicListBean> thematicList;

        public static ThematicsBean objectFromData(String str) {

            return new Gson().fromJson(str, ThematicsBean.class);
        }

        public static ThematicsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ThematicsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ThematicsBean> arrayThematicsBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ThematicsBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ThematicsBean> arrayThematicsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ThematicsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getThematicNum() {
            return thematicNum;
        }

        public void setThematicNum(int thematicNum) {
            this.thematicNum = thematicNum;
        }

        public List<ThematicListBean> getThematicList() {
            return thematicList;
        }

        public void setThematicList(List<ThematicListBean> thematicList) {
            this.thematicList = thematicList;
        }

        public static class ThematicListBean {
            private int thematicId;
            private String name;
            private double thematicArea;
            private String img;

            public static ThematicListBean objectFromData(String str) {

                return new Gson().fromJson(str, ThematicListBean.class);
            }

            public static ThematicListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ThematicListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ThematicListBean> arrayThematicListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ThematicListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ThematicListBean> arrayThematicListBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ThematicListBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public int getThematicId() {
                return thematicId;
            }

            public void setThematicId(int thematicId) {
                this.thematicId = thematicId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getThematicArea() {
                return thematicArea;
            }

            public void setThematicArea(double thematicArea) {
                this.thematicArea = thematicArea;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }

    public static class ToolsBean {
        private int toolNum;
        private List<?> toolList;

        public static ToolsBean objectFromData(String str) {

            return new Gson().fromJson(str, ToolsBean.class);
        }

        public static ToolsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ToolsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ToolsBean> arrayToolsBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ToolsBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ToolsBean> arrayToolsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ToolsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getToolNum() {
            return toolNum;
        }

        public void setToolNum(int toolNum) {
            this.toolNum = toolNum;
        }

        public List<?> getToolList() {
            return toolList;
        }

        public void setToolList(List<?> toolList) {
            this.toolList = toolList;
        }
    }

    public static class SugBean {
        private String name;
        private int num;
        private List<CitesBean> cites;

        public static SugBean objectFromData(String str) {

            return new Gson().fromJson(str, SugBean.class);
        }

        public static SugBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), SugBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<SugBean> arraySugBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<SugBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<SugBean> arraySugBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<SugBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<CitesBean> getCites() {
            return cites;
        }

        public void setCites(List<CitesBean> cites) {
            this.cites = cites;
        }

        public static class CitesBean {
            private String name;
            private String num;
            private String citycode;
            private String adcode;

            public static CitesBean objectFromData(String str) {

                return new Gson().fromJson(str, CitesBean.class);
            }

            public static CitesBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), CitesBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<CitesBean> arrayCitesBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<CitesBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<CitesBean> arrayCitesBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<CitesBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getCitycode() {
                return citycode;
            }

            public void setCitycode(String citycode) {
                this.citycode = citycode;
            }

            public String getAdcode() {
                return adcode;
            }

            public void setAdcode(String adcode) {
                this.adcode = adcode;
            }
        }
    }
}
