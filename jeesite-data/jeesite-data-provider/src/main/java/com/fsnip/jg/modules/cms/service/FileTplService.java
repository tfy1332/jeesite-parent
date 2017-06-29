package com.fsnip.jg.modules.cms.service;

import com.fsnip.jg.common.persistence.Page;
import com.fsnip.jg.common.utils.SpringContextHolder;
import com.fsnip.jg.modules.cms.entity.FileTpl;
import com.fsnip.jg.modules.cms.service.filetpl.IFileTplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * User: songlai
 * Date: 13-8-27
 * Time: 下午4:56
 */
@Service
@Transactional(readOnly = true)
public class FileTplService  implements IFileTplService {

//    @Autowired
    ServletContext context;
//    private static ServletContext context = SpringContextHolder.getBean(ServletContext.class);


    public List<String> getNameListByPrefix(String path) {
        List<FileTpl> list = getListByPath(path, false);
        List<String> result = new ArrayList<String>(list.size());
        for (FileTpl tpl : list) {
            result.add(tpl.getName());
        }
        return result;
    }

    public List<FileTpl> getListByPath(String path, boolean directory) {
   		File f = new File(context.getRealPath(path));
   		if (f.exists()) {
   			File[] files = f.listFiles();
   			if (files != null) {
   				List<FileTpl> list = new ArrayList<FileTpl>();
   				for (File file : files) {
                    if(file.isFile() || directory)
   					    list.add(new FileTpl(file, context.getRealPath("")));
   				}
   				return list;
   			} else {
   				return new ArrayList<FileTpl>(0);
   			}
   		} else {
   			return new ArrayList<FileTpl>(0);
   		}
   	}

    public List<FileTpl> getListForEdit(String path){
        List<FileTpl> list = getListByPath(path, true);
        List<FileTpl> result = new ArrayList<FileTpl>();
        result.add(new FileTpl(new File(context.getRealPath(path)), context.getRealPath("")));
        getAllDirectory(result, list);
        return result;
    }

    private void getAllDirectory(List<FileTpl> result, List<FileTpl> list){
        for (FileTpl tpl : list) {
            result.add(tpl);
            if(tpl.isDirectory()){
                getAllDirectory(result, getListByPath(tpl.getName(), true));
            }
        }
    }

    public FileTpl getFileTpl(String name) {
   		File f = new File(context.getRealPath(name));
   		if (f.exists()) {
   			return new FileTpl(f, "");
   		} else {
   			return null;
   		}
   	}

    public void save(FileTpl entity) {

    }

    public FileTpl get(String id) {
        return null;
    }

    public FileTpl get(FileTpl entity) {
        return null;
    }

    public Page<FileTpl> findPage(Page<FileTpl> page, FileTpl fileTpl) {
        return null;
    }

    public void delete(FileTpl entity) {

    }

    public void delete(FileTpl entity, Boolean isRe) {

    }

    public List<FileTpl> findList(FileTpl fileTpl) {
        return null;
    }
}
