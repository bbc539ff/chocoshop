package com.chocoshop.controller;

import com.chocoshop.model.Goods;
import com.chocoshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WangEditorController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/admin/goods-info/{goodsId}/editor")
    public String editor(){
        return "editor";
    }

    @RequestMapping("/admin/goods-info/{goodsId}/submit")
    @ResponseBody
    public String submit(String data, @PathVariable Long goodsId){
        try{
            Goods goods = new Goods();
            goods.setGoodsId(goodsId);
            goods.setGoodsDetail(data);
            goodsService.updateGoods(goods, null);
            return "succcess";
        } catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/admin/goods-info/{goodsId}/detail")
    @ResponseBody
    public String submit(@PathVariable Long goodsId){
        String data = goodsService.findByGoodsId(goodsId);
        return data;
    }

    @RequestMapping("/admin/goods-info/{goodsId}/upload")
    @ResponseBody
    public UploadStatusJson upload(@PathVariable Long goodsId, MultipartFile[] files){
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);

        UploadStatusJson uploadStatusJson = new UploadStatusJson();

        if(goodsService.updateGoodsDetail(goods, files) == 1){
            uploadStatusJson.setErrno(0);
            List<String> list = new ArrayList<>();
            for (MultipartFile file : files) {
                list.add("/upload/goods/detail/"+goodsId+"/"+file.getOriginalFilename());
            }
            uploadStatusJson.setData(list);
            return uploadStatusJson;
        } else{
            uploadStatusJson.setErrno(1);
            return uploadStatusJson;
        }
    }

    class UploadStatusJson {
        Integer errno;
        List<String> data;

        public Integer getErrno() {
            return errno;
        }

        public void setErrno(Integer errno) {
            this.errno = errno;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "UploadStatusJson{" +
                    "errno=" + errno +
                    ", data=" + data +
                    '}';
        }
    }

}
