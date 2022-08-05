package com.atguigu.test;

import com.atguigu.bean.KEYWORDS_T_MALL_SKU;
import com.atguigu.factory.MySqlSessionFactory;
import com.atguigu.mapper.ClassMapper;
import com.atguigu.util.MyPropertiesUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.List;

/**
 * @author jian
 * @create 2022-08-04 18:13
 */
public class Test {
    public static void main(String[] args) throws Exception {

        SqlSessionFactory myF = MySqlSessionFactory.getMyF();

        ClassMapper mapper = myF.openSession().getMapper(ClassMapper.class);

        List<KEYWORDS_T_MALL_SKU> list_sku = mapper.select_list_by_flbh2(16);

        System.out.println(list_sku);

        //向solr中导入数据

        HttpSolrServer solr = new HttpSolrServer(MyPropertiesUtil.getMyProperty("solr.properties","solr_sku1018"));
        solr.setParser(new XMLResponseParser());
        solr.addBeans(list_sku);
        solr.commit();

        //查询对象
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("sku_mch:pro16");
        solrQuery.setRows(50);

        QueryResponse query = solr.query(solrQuery);

        List<KEYWORDS_T_MALL_SKU> beans = query.getBeans(KEYWORDS_T_MALL_SKU.class);

        System.out.println(beans);

    }
}
