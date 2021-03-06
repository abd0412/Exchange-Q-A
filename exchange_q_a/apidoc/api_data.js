define({ "api": [
  {
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "optional": false,
            "field": "varname1",
            "description": "<p>No type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "varname2",
            "description": "<p>With type.</p>"
          }
        ]
      }
    },
    "type": "",
    "url": "",
    "version": "0.0.0",
    "filename": "exchange_q_a/apidoc/main.js",
    "group": "D:\\java-project\\exchange_q_a\\apidoc\\main.js",
    "groupTitle": "D:\\java-project\\exchange_q_a\\apidoc\\main.js",
    "name": ""
  },
  {
    "type": "post",
    "url": "/upload/image",
    "title": "上传图片",
    "version": "0.0.1",
    "description": "<p>上传图片</p>",
    "group": "上传-Upload",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "File",
            "optional": false,
            "field": "signImgFile",
            "description": "<p>图片key</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-上传成功；2001-上传失败；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "data",
            "description": "<p>图片url</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"添加成功\",\n    \"data\": \"http://120.79.31.81/imagesUpload/756c7196-a944-4e25-bc82-75eccc99fbf8.jpg\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": \"2001\",\n\t   \"Message\": \"上传失败\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/UploadController.java",
    "groupTitle": "上传-Upload",
    "name": "PostUploadImage",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/upload/image"
      }
    ]
  },
  {
    "type": "get",
    "url": "/answer/selectList?problemId=1&pageNumber=1&pageLength=10",
    "title": "分页查询某问题的回答",
    "version": "0.0.1",
    "description": "<p>根据问题id查询该问题的所有回答</p>",
    "group": "回答-Answer",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "problemId",
            "description": "<p>问题id，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageNumber",
            "description": "<p>页码，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageLength",
            "description": "<p>页面长度，必填，唯一限定某一值</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "answerList",
            "description": "<p>回答列表</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功：页码1包含的所有回答信息\",\n    \"data\": {\n        \"answerList\": [\n            {\n                \"answerId\": 1,\n                \"problemId\": 1,\n                \"userId\": 1,\n                \"answerContent\": \"<p>xxx</p >\",\n                \"declare\": 1,\n                \"isAnonymity\": true,\n                \"introduce\": null,\n                \"isPush\": true,\n                \"isAllowed\": true,\n                \"isRestriction\": false,\n                \"restrictionType\": null,\n                \"agreeNumber\": null,\n                \"disagreeNumber\": null,\n                \"commentNumber\": null,\n                \"mark\": null,\n                \"createTime\": \"2021-11-05 15:24:46.0\",\n                \"updateTime\": null,\n                \"isDelete\": false,\n                \"answerAbbreviatedContent\": null\n            },\n            {\n                \"answerId\": 2,\n                \"problemId\": 1,\n                \"userId\": 1,\n                \"answerContent\": \"<p>xxx</p >\",\n                \"declare\": 1,\n                \"isAnonymity\": true,\n                \"introduce\": null,\n                \"isPush\": true,\n                \"isAllowed\": true,\n                \"isRestriction\": false,\n                \"restrictionType\": null,\n                \"agreeNumber\": null,\n                \"disagreeNumber\": null,\n                \"commentNumber\": null,\n                \"mark\": null,\n                \"createTime\": \"2021-11-05 15:38:58.0\",\n                \"updateTime\": null,\n                \"isDelete\": false,\n                \"answerAbbreviatedContent\": \"xxx\"\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/AnswerController.java",
    "groupTitle": "回答-Answer",
    "name": "GetAnswerSelectlistProblemid1Pagenumber1Pagelength10",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/answer/selectList?problemId=1&pageNumber=1&pageLength=10"
      }
    ]
  },
  {
    "type": "post",
    "url": "/answer/add",
    "title": "写回答",
    "version": "0.0.1",
    "description": "<p>写回答的接口</p>",
    "group": "回答-Answer",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "problemId",
            "description": "<p>问题id，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>回答的用户id，必填</p>"
          },
          {
            "group": "入参",
            "type": "text",
            "optional": false,
            "field": "answerContent",
            "description": "<p>回答内容，必填</p>"
          },
          {
            "group": "入参",
            "type": "text",
            "optional": false,
            "field": "answerAbbreviatedContent",
            "description": "<p>回答的收起的缩略内容</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "declare",
            "description": "<p>创作声明，暂分类为：0：无声明（默认）; 1：虚假创作; 2: 包含理财内容; 3: 包含剧透；4：包含医疗建议;</p>"
          },
          {
            "group": "入参",
            "type": "boolean",
            "optional": false,
            "field": "isAnonymity",
            "description": "<p>是否匿名，0：不匿名（默认）；1：匿名</p>"
          },
          {
            "group": "入参",
            "type": "string",
            "optional": false,
            "field": "introduce",
            "description": "<p>一句话介绍</p>"
          },
          {
            "group": "入参",
            "type": "boolean",
            "optional": false,
            "field": "isPush",
            "description": "<p>是否推送给关注者，0：不推；1：推送（默认）</p>"
          },
          {
            "group": "入参",
            "type": "boolean",
            "optional": false,
            "field": "isAllowed",
            "description": "<p>是否允许转载，0：不允许; 1: 允许（默认）</p>"
          },
          {
            "group": "入参",
            "type": "boolean",
            "optional": false,
            "field": "isRestriction",
            "description": "<p>是否限制评论，0：不限制（系统默认）; 1: 限制</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "restrictionType",
            "description": "<p>限制类型，若限制开启则：1：允许我关注的人评论；2：答主筛选显示；3：禁止评论</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"problemId\": 1,\n    \"userId\": 1,\n    \"answerContent\": \"<p>xxx</p >\",\n    \"answerAbbreviatedContent\": \"xxx\",\n    \"declare\": 1,\n    \"isAnonymity\": 1,\n    \"introduce\": \"\",\n    \"isPush\": 1,\n    \"isAllowed\": 1,\n    \"isRestriction\": 0\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>添加的对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"添加成功\",\n    \"data\": {\n        \"answerId\": 2,\n        \"problemId\": 1,\n        \"userId\": 1,\n        \"answerContent\": \"<p>xxx</p >\",\n        \"declare\": 1,\n        \"isAnonymity\": true,\n        \"introduce\": null,\n        \"isPush\": true,\n        \"isAllowed\": true,\n        \"isRestriction\": false,\n        \"restrictionType\": null,\n        \"agreeNumber\": null,\n        \"disagreeNumber\": null,\n        \"commentNumber\": null,\n        \"mark\": null,\n        \"createTime\": \"2021-11-05 15:38:58\",\n        \"updateTime\": null,\n        \"isDelete\": null,\n        \"answerAbbreviatedContent\": \"xxx\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/AnswerController.java",
    "groupTitle": "回答-Answer",
    "name": "PostAnswerAdd",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/answer/add"
      }
    ]
  },
  {
    "type": "get",
    "url": "/relation/delete?relationId=4",
    "title": "取消操作",
    "version": "0.0.1",
    "description": "<p>取消单项操作，真删除关系。</p>",
    "group": "操作-Relation",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "relationId",
            "description": "<p>操作id（添加时返回），必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-调用成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "data",
            "description": "<p>取消操作4成功/取消操作1不存在</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"调用成功\",\n    \"data\": \"取消操作4成功\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/RelationController.java",
    "groupTitle": "操作-Relation",
    "name": "GetRelationDeleteRelationid4",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/relation/delete?relationId=4"
      }
    ]
  },
  {
    "type": "get",
    "url": "/relation/select?userId=1&moduleCode=1&moduleId=1",
    "title": "查询操作",
    "version": "0.0.1",
    "description": "<p>查询用户操作（不包含邀请回答和收藏），用于前端页面显示用户操作，userId为必填，其它选填。eg：userId=1&amp;moduleCode=1&amp;moduleId=1，释义：查询用户1对问题1的所有操作。</p>",
    "group": "操作-Relation",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>登录用户的id（系统生成唯一，在用户登录时返回），必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleCode",
            "description": "<p>对象类型，1：problem；2：answer；3：comment；4：article； 5：idea；6：user；7：favorites；</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleId",
            "description": "<p>对象id</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>查询对象，释义：用户1对问题1有两个操作分别是关注了问题、认为是好问题。</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"relationList\": [\n            {\n                \"relationId\": 1,\n                \"userId\": 1,\n                \"moduleCode\": 1,\n                \"moduleId\": 1,\n                \"relationType\": 2,\n                \"mark\": null,\n                \"createTime\": \"2021-11-08 17:05:16.0\",\n                \"updateTime\": null,\n                \"isDelete\": false\n            },\n            {\n                \"relationId\": 12,\n                \"userId\": 1,\n                \"moduleCode\": 1,\n                \"moduleId\": 1,\n                \"relationType\": 1,\n                \"mark\": null,\n                \"createTime\": \"2021-11-08 20:11:14.0\",\n                \"updateTime\": null,\n                \"isDelete\": false\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/RelationController.java",
    "groupTitle": "操作-Relation",
    "name": "GetRelationSelectUserid1Modulecode1Moduleid1",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/relation/select?userId=1&moduleCode=1&moduleId=1"
      }
    ]
  },
  {
    "type": "post",
    "url": "/relation/add",
    "title": "添加操作",
    "version": "0.0.1",
    "description": "<p>该接口应用于：添加登录的用户对问题/回答/评论/文章/想法/其他用户/其他用户的收藏夹7个对象进行的单项操作，操作以单项的形式进行叠加，不包含邀请回答和收藏。</p>",
    "group": "操作-Relation",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>登录用户的id（系统生成唯一，在用户登录时返回），必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleCode",
            "description": "<p>登录用户对什么类型的对象进行了操作：1：problem；2：answer；3：comment；4：article； 5：idea；6：user；7：favorites，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleId",
            "description": "<p>操作对象id(problemId/answerId/commentId/articleId/ideaId/userId/favoritesId)，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "relationType",
            "description": "<p>用户对对象的操作类型： 问题：（1：关注问题；2：好问题；） 回答：（1：赞同；2：不赞同；3：喜欢；） 评论：（1：赞；2：踩；） 文章：（1：赞同；2：不赞同；3：喜欢；4：已转载；） 想法：（1：鼓掌；） 其他用户：（1：关注；） 其他用户的收藏夹：（1：关注；）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"userId\": 1,\n    \"moduleCode\": 1,\n    \"moduleId\": 1,\n    \"relationType\": 1\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>添加对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"操作成功\",\n    \"data\": {\n        \"relationId\": 18,\n        \"userId\": 1,\n        \"moduleCode\": 1,\n        \"moduleId\": 1,\n        \"relationType\": 1,\n        \"mark\": null,\n        \"createTime\": \"2021-11-08 22:49:55\",\n        \"updateTime\": null,\n        \"isDelete\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/RelationController.java",
    "groupTitle": "操作-Relation",
    "name": "PostRelationAdd",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/relation/add"
      }
    ]
  },
  {
    "type": "get",
    "url": "/collect/delete?collectId=4",
    "title": "取消收藏",
    "version": "0.0.1",
    "description": "<p>取消收藏，真删除关系。</p>",
    "group": "收藏-collect",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "collectId",
            "description": "<p>收藏关系id（查询收藏时返回），必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-调用成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "data",
            "description": "<p>取消操作4成功/取消操作1不存在</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"调用成功\",\n    \"data\": \"取消收藏1成功\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/CollectController.java",
    "groupTitle": "收藏-collect",
    "name": "GetCollectDeleteCollectid4",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/collect/delete?collectId=4"
      }
    ]
  },
  {
    "type": "get",
    "url": "/collect/selectList?userId=1&moduleCode=1&moduleId=1",
    "title": "查询收藏",
    "version": "0.0.1",
    "description": "<p>查询用户收藏某回答/文章/想法的情况</p>",
    "group": "收藏-collect",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>收藏用户id，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleCode",
            "description": "<p>被收藏对象类型：1：回答；2：文章；3：想法；必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleId",
            "description": "<p>被收藏对象id，对应于answerId/articleId/ideaId，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>查询对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"collectList\": [\n            {\n                \"collectId\": 1,\n                \"userId\": 1,\n                \"moduleCode\": 1,\n                \"moduleId\": 1,\n                \"favoritesId\": 1,\n                \"mark\": null,\n                \"createTime\": \"2021-11-10 15:10:28.0\",\n                \"isDelete\": false\n            },\n            {\n                \"collectId\": 3,\n                \"userId\": 1,\n                \"moduleCode\": 1,\n                \"moduleId\": 1,\n                \"favoritesId\": 2,\n                \"mark\": null,\n                \"createTime\": null,\n                \"isDelete\": false\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/CollectController.java",
    "groupTitle": "收藏-collect",
    "name": "GetCollectSelectlistUserid1Modulecode1Moduleid1",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/collect/selectList?userId=1&moduleCode=1&moduleId=1"
      }
    ]
  },
  {
    "type": "post",
    "url": "/collect/add",
    "title": "进行收藏",
    "version": "0.0.1",
    "description": "<p>用户收藏回答/文章/想法的接口，ps：一个对象可以被收藏进多个收藏夹</p>",
    "group": "收藏-collect",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>收藏用户id，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleCode",
            "description": "<p>被收藏对象类型：1：回答；2：文章；3：想法；必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleId",
            "description": "<p>被收藏对象id，对应于answerId/articleId/ideaId，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "favoritesId",
            "description": "<p>收藏夹id，必填</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"userId\": 1,\n    \"moduleCode\": 1,\n    \"moduleId\": 1,\n    \"favoritesId\": 1\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>添加对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"添加成功\",\n    \"data\": {\n        \"collectId\": 1,\n        \"userId\": 1,\n        \"moduleCode\": 1,\n        \"moduleId\": 1,\n        \"favoritesId\": 1,\n        \"mark\": null,\n        \"createTime\": \"2021-11-10 15:12:48\",\n        \"isDelete\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/CollectController.java",
    "groupTitle": "收藏-collect",
    "name": "PostCollectAdd",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/collect/add"
      }
    ]
  },
  {
    "type": "get",
    "url": "/favorites/selectList?userId=1",
    "title": "查询收藏夹",
    "version": "0.0.1",
    "description": "<p>查询用户收藏夹的接口</p>",
    "group": "收藏夹-Favorites",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>查询列表</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"favoritesList\": [\n            {\n                \"favoritesId\": 1,\n                \"userId\": 1,\n                \"favoritesTitle\": \"我的收藏夹\",\n                \"favoritesDescribe\": null,\n                \"isLimit\": false,\n                \"contentNumber\": 0,\n                \"followerNumber\": 1,\n                \"mark\": null,\n                \"createTime\": \"2021-11-08 20:53:16.0\",\n                \"updateTime\": null,\n                \"isDelete\": false\n            },\n            {\n                \"favoritesId\": 2,\n                \"userId\": 1,\n                \"favoritesTitle\": \"考研资料\",\n                \"favoritesDescribe\": null,\n                \"isLimit\": false,\n                \"contentNumber\": 0,\n                \"followerNumber\": 0,\n                \"mark\": \"\",\n                \"createTime\": \"2021-11-09 20:55:57.0\",\n                \"updateTime\": null,\n                \"isDelete\": false\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/FavoritesController.java",
    "groupTitle": "收藏夹-Favorites",
    "name": "GetFavoritesSelectlistUserid1",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/favorites/selectList?userId=1"
      }
    ]
  },
  {
    "type": "post",
    "url": "/favorites/add",
    "title": "创建收藏夹",
    "version": "0.0.1",
    "description": "<p>用户创建收藏夹的接口</p>",
    "group": "收藏夹-Favorites",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>创建收藏夹的用户id，必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "favoritesTitle",
            "description": "<p>，收藏夹标题，必填，系统默认：我的收藏夹</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "favoritesDescribe",
            "description": "<p>收藏夹描述，选填</p>"
          },
          {
            "group": "入参",
            "type": "boolean",
            "optional": false,
            "field": "isLimit",
            "description": "<p>公开还是私密，0：公开（默认），1：私密</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"userId\": 1,\n    \"favoritesTitle\": \"考研资料\",\n    \"favoritesDescribe\": null,\n    \"isLimit\": 0\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>添加的对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"添加成功\",\n    \"data\": {\n        \"favoritesId\": 2,\n        \"userId\": 1,\n        \"favoritesTitle\": \"考研资料\",\n        \"favoritesDescribe\": null,\n        \"isLimit\": false,\n        \"contentNumber\": null,\n        \"followerNumber\": null,\n        \"mark\": null,\n        \"createTime\": \"2021-11-09 20:55:57\",\n        \"updateTime\": null,\n        \"isDelete\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/FavoritesController.java",
    "groupTitle": "收藏夹-Favorites",
    "name": "PostFavoritesAdd",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/favorites/add"
      }
    ]
  },
  {
    "type": "get",
    "url": "/article/select?articleId=2",
    "title": "查询某文章",
    "version": "0.0.1",
    "description": "<p>根据文章id获取该文章的所有信息</p>",
    "group": "文章-Article",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "articleId",
            "description": "<p>文章id，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>查询对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"articleId\": 2,\n        \"userId\": 1,\n        \"articleTitle\": \"100个英语词组\",\n        \"articleContent\": \"<p>xxx</p >\",\n        \"linkName\": null,\n        \"linkUrl\": null,\n        \"declare\": 1,\n        \"introduce\": null,\n        \"isPush\": true,\n        \"isAllowed\": true,\n        \"isRestriction\": false,\n        \"restrictionType\": null,\n        \"agreeNumber\": null,\n        \"disagreeNumber\": null,\n        \"commentNumber\": null,\n        \"mark\": null,\n        \"createTime\": \"2021-11-04 23:16:05.0\",\n        \"updateTime\": null,\n        \"isDelete\": false,\n        \"articleCoverUrl\": \"http://10.12.0.158:8383/imagesUpload/478ce7df-b69d-43ae-804c-4f6d7eca83d0.jpg\",\n        \"abbreviatedContent\": \"xxx\",\n        \"tagList\": [\n            {\n                \"tagId\": 1\n            },\n            {\n                \"tagId\": 2\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/ArticleController.java",
    "groupTitle": "文章-Article",
    "name": "GetArticleSelectArticleid2",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/article/select?articleId=2"
      }
    ]
  },
  {
    "type": "get",
    "url": "/article/selectList?pageNumber=2&pageLength=10",
    "title": "查询所有文章",
    "version": "0.0.1",
    "description": "<p>分页查询所有文章</p>",
    "group": "文章-Article",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageNumber",
            "description": "<p>页码，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageLength",
            "description": "<p>页面长度，必填，唯一限定某一值</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "articleList",
            "description": "<p>文章列表</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功：页码2包含的所有文章信息\",\n    \"data\": {\n        \"articleList\": [\n            {\n                \"articleId\": 3,\n                \"userId\": 1,\n                \"articleTitle\": \"100个英语词组\",\n                \"articleContent\": \"<p>xxx</p >\",\n                \"linkName\": null,\n                \"linkUrl\": null,\n                \"declare\": 1,\n                \"introduce\": null,\n                \"isPush\": true,\n                \"isAllowed\": true,\n                \"isRestriction\": false,\n                \"restrictionType\": null,\n                \"agreeNumber\": 0,\n                \"disagreeNumber\": 0,\n                \"commentNumber\": 0,\n                \"mark\": null,\n                \"createTime\": \"2021-11-11 19:40:39.0\",\n                \"updateTime\": null,\n                \"isDelete\": false,\n                \"articleCoverUrl\": \"http://10.12.0.158:8383/imagesUpload/478ce7df-b69d-43ae-804c-4f6d7eca83d0.jpg\",\n                \"abbreviatedContent\": \"xxx\",\n                \"tagList\": null\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/ArticleController.java",
    "groupTitle": "文章-Article",
    "name": "GetArticleSelectlistPagenumber2Pagelength10",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/article/selectList?pageNumber=2&pageLength=10"
      }
    ]
  },
  {
    "type": "post",
    "url": "/article/add",
    "title": "发布文章",
    "version": "0.0.1",
    "description": "<p>用户发布文章的接口</p>",
    "group": "文章-Article",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>文章的用户id（系统生成唯一，在用户登录时返回），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "articleTitle",
            "description": "<p>文章标题，必填</p>"
          },
          {
            "group": "入参",
            "type": "text",
            "optional": false,
            "field": "articleContent",
            "description": "<p>文章内容，必填</p>"
          },
          {
            "group": "入参",
            "type": "text",
            "optional": false,
            "field": "abbreviatedContent",
            "description": "<p>收起的缩略内容</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "articleCoverUrl",
            "description": "<p>文章封面（调用图片上传接口），选填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "declare",
            "description": "<p>创作声明，暂分类为：0：无声明（默认）; 1：虚假创作; 2: 包含理财内容; 3: 包含剧透；4：包含医疗建议;</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "tagList",
            "description": "<p>标签列表，至少带一个，文章带的话题是个标签，所属分类是话题</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "tagId",
            "description": "<p>标签id，值列表，需数据库中拥有。</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"userId\": 1,\n    \"articleTitle\": \"100个英语词组\",\n    \"articleContent\": \"<p>xxx</p >\",\n    \"abbreviatedContent\": \"xxx\",\n    \"articleCoverUrl\": \"http://10.12.0.158:8383/imagesUpload/478ce7df-b69d-43ae-804c-4f6d7eca83d0.jpg\",\n    \"declare\": 1,\n    \"tagList\": [\n            {\n                \"tagId\": 1\n            },\n            {\n                \"tagId\": 2\n            }\n        ]\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>添加对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"添加成功\",\n    \"data\": {\n        \"articleId\": 2,\n        \"userId\": 1,\n        \"articleTitle\": \"100个英语词组\",\n        \"articleContent\": \"<p>xxx</p >\",\n        \"linkName\": null,\n        \"linkUrl\": null,\n        \"declare\": 1,\n        \"introduce\": null,\n        \"isPush\": null,\n        \"isAllowed\": null,\n        \"isRestriction\": null,\n        \"restrictionType\": null,\n        \"agreeNumber\": null,\n        \"disagreeNumber\": null,\n        \"commentNumber\": null,\n        \"mark\": null,\n        \"createTime\": \"2021-11-04 23:16:05\",\n        \"updateTime\": null,\n        \"isDelete\": null,\n        \"articleCoverUrl\": \"http://10.12.0.158:8383/imagesUpload/478ce7df-b69d-43ae-804c-4f6d7eca83d0.jpg\",\n        \"abbreviatedContent\": \"xxx\",\n        \"tagList\": [\n            {\n                \"tagId\": 1\n            },\n            {\n                \"tagId\": 2\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/ArticleController.java",
    "groupTitle": "文章-Article",
    "name": "PostArticleAdd",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/article/add"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tag/select?tagId=1",
    "title": "查询标签信息",
    "version": "0.0.1",
    "description": "<p>根据标签id获取该标签的所有信息</p>",
    "group": "标签-Tag",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "tagId",
            "description": "<p>标签id，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>查询对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"tagId\": 1,\n        \"categoryId\": 1,\n        \"tagContent\": \"战机\",\n        \"mark\": \"测试使用\",\n        \"note\": null,\n        \"createTime\": \"2021-11-04T07:54:17.000+0000\",\n        \"updateTime\": null,\n        \"isDelete\": false\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/TagController.java",
    "groupTitle": "标签-Tag",
    "name": "GetTagSelectTagid1",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/tag/select?tagId=1"
      }
    ]
  },
  {
    "type": "get",
    "url": "/user/select?userId=2",
    "title": "查询用户信息",
    "version": "0.0.1",
    "description": "<p>根据用户id查询该用户的详细信息</p>",
    "group": "用户-User",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>查询对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"userId\": 2,\n        \"name\": \"秦硕\",\n        \"password\": \"000000\",\n        \"sex\": 0,\n        \"introduce\": null,\n        \"address\": null,\n        \"industry\": null,\n        \"profession\": null,\n        \"education\": null,\n        \"authentication\": null,\n        \"briefIntroduction\": null,\n        \"headLogo\": \"http://10.12.0.158:8383/imagesUpload/b5abc5df-2f22-4449-ae80-1855977aaaa8.jpg\",\n        \"mark\": null,\n        \"createTime\": \"2021-11-05T13:24:17.000+0000\",\n        \"updateTime\": null,\n        \"isDelete\": false,\n        \"account\": \"qinshuo2\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/UserController.java",
    "groupTitle": "用户-User",
    "name": "GetUserSelectUserid2",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/user/select?userId=2"
      }
    ]
  },
  {
    "type": "post",
    "url": "/account/login",
    "title": "用户登录",
    "version": "0.0.1",
    "description": "<p>用户登录接口，通过账号和密码登录，账号为系统分配，默认密码000000，可支持修改和忘记密码。</p>",
    "group": "登录-Login",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "account",
            "description": "<p>用户登录账号，唯一，系统分配（lihaopeng1  000000）。</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码，初始密码为000000。</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"account\": \"lihaopeng1\",\n    \"password\": \"000000\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-验证成功；1201-无此用户，验证失败；1202-密码错误，验证失败；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "JSONObject",
            "optional": false,
            "field": "data",
            "description": "<p>用户相关信息</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"验证成功\",\n    \"data\": {\n        \"userId\": 1,\n        \"userName\": \"李浩鹏\",\n        \"password\": \"000000\",\n        \"sex\": 0,\n        \"introduce\": null,\n        \"address\": null,\n        \"industry\": null,\n        \"profession\": null,\n        \"education\": null,\n        \"authentication\": null,\n        \"briefIntroduction\": null,\n        \"headLogo\": null,\n        \"mark\": null,\n        \"createTime\": \"2021-11-02T09:18:38.000+0000\",\n        \"updateTime\": null,\n        \"isDelete\": false,\n        \"account\": \"lihaopeng1\"\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 1201,\n    \"message\": \"无此用户，验证失败\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/LoginController.java",
    "groupTitle": "登录-Login",
    "name": "PostAccountLogin",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/account/login"
      }
    ]
  },
  {
    "type": "get",
    "url": "/comment/child_selectList?moduleId=49&pageNumber=1&pageLength=4",
    "title": "查询子评论",
    "version": "0.0.1",
    "description": "<p>分页查询评论下的回复</p>",
    "group": "评论-Comment",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleId",
            "description": "<p>被回复的评论id， 必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageNumber",
            "description": "<p>页码，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageLength",
            "description": "<p>页面长度，必填，唯一限定某一值</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-调用成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "data",
            "description": "<p>查询对象</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "responseList",
            "description": "<p>根评论下的回复</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "totalPages",
            "description": "<p>分页数</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"responseList\": [\n            {\n                \"comment\": {\n                    \"commentId\": 50,\n                    \"userId\": 2,\n                    \"commentContent\": \"用户2对评论49的回复\",\n                    \"moduleCode\": 3,\n                    \"moduleId\": 49,\n                    \"approvalNumber\": 0,\n                    \"mark\": null,\n                    \"createTime\": \"2021-11-17 10:49:53.0\",\n                    \"updateTime\": null,\n                    \"isDelete\": false,\n                    \"subCommentList\": null,\n                    \"rootModuleCode\": 2,\n                    \"rootModuleId\": 7,\n                    \"rootCommentId\": 49,\n                    \"responseNumber\": 0\n                },\n                \"replyUser\": {\n                    \"userId\": 2,\n                    \"account\": \"qinshuo2\",\n                    \"password\": \"000000\",\n                    \"name\": \"秦硕\",\n                    \"sex\": 0,\n                    \"introduce\": null,\n                    \"address\": null,\n                    \"industry\": null,\n                    \"profession\": null,\n                    \"education\": null,\n                    \"authentication\": null,\n                    \"briefIntroduction\": null,\n                    \"headLogo\": \"http://10.12.0.158:8383/imagesUpload/b5abc5df-2f22-4449-ae80-1855977aaaa8.jpg\",\n                    \"followerNumber\": 3,\n                    \"mark\": null,\n                    \"createTime\": \"2021-11-05 21:24:17.0\",\n                    \"updateTime\": null,\n                    \"isDelete\": false\n                },\n                \"beRepliedUser\": {\n                    \"userId\": 1,\n                    \"account\": \"lihaopeng1\",\n                    \"password\": \"000000\",\n                    \"name\": \"李浩鹏\",\n                    \"sex\": 0,\n                    \"introduce\": null,\n                    \"address\": null,\n                    \"industry\": null,\n                    \"profession\": null,\n                    \"education\": null,\n                    \"authentication\": null,\n                    \"briefIntroduction\": null,\n                    \"headLogo\": \"http://10.12.0.158:8383/imagesUpload/ba784a17-8dd4-4ee3-896a-9b42f52d265c.jpg\",\n                    \"followerNumber\": 0,\n                    \"mark\": null,\n                    \"createTime\": \"2021-11-02 17:18:38.0\",\n                    \"updateTime\": null,\n                    \"isDelete\": false\n                }\n            }\n        ],\n        \"totalPages\": 4\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/CommentController.java",
    "groupTitle": "评论-Comment",
    "name": "GetCommentChild_selectlistModuleid49Pagenumber1Pagelength4",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/comment/child_selectList?moduleId=49&pageNumber=1&pageLength=4"
      }
    ]
  },
  {
    "type": "get",
    "url": "/comment/delete?commentId=49",
    "title": "删除评论",
    "version": "0.0.1",
    "description": "<p>根据评论id逻辑删除该条评论，并做逻辑级联删除。</p>",
    "group": "评论-Comment",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "commentId",
            "description": "<p>评论id，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-调用成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "data",
            "description": "<p>删除评论x成功/删除评论x不存在</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"调用成功\",\n    \"data\": \"级联删除评论49成功\"\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/CommentController.java",
    "groupTitle": "评论-Comment",
    "name": "GetCommentDeleteCommentid49",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/comment/delete?commentId=49"
      }
    ]
  },
  {
    "type": "get",
    "url": "/comment/root_selectList?moduleCode=2&moduleId=7&pageNumber=1&pageLength=10",
    "title": "查询根评论",
    "version": "0.0.1",
    "description": "<p>查询问题/回答/评论/文章/想法下的根评论及其两个子评论，用于初级显示。</p>",
    "group": "评论-Comment",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleCode",
            "description": "<p>评论针对的对象类型，1：problem；2：answer；4：article；5：idea；必填。</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleId",
            "description": "<p>评论所针对的对象的id， 必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageNumber",
            "description": "<p>页码，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageLength",
            "description": "<p>页面长度，必填，唯一限定某一值</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-调用成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "data",
            "description": "<p>查询对象</p>"
          },
          {
            "group": "出参",
            "type": "array",
            "optional": false,
            "field": "responseList",
            "description": "<p>第一层评论和其两个子评论</p>"
          },
          {
            "group": "出参",
            "type": "int",
            "optional": false,
            "field": "totalPages",
            "description": "<p>分页数</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"responseList\": [\n            {\n                \"comment\": {\n                    \"commentId\": 49,\n                    \"userId\": 1,\n                    \"commentContent\": \"用户1对回答7的评论\",\n                    \"moduleCode\": 2,\n                    \"moduleId\": 7,\n                    \"approvalNumber\": 0,\n                    \"mark\": null,\n                    \"createTime\": \"2021-11-17 10:48:24.0\",\n                    \"updateTime\": null,\n                    \"isDelete\": false,\n                    \"subCommentList\": [\n                        {\n                            \"comment\": {\n                                \"commentId\": 50,\n                                \"userId\": 2,\n                                \"commentContent\": \"用户2对评论49的回复\",\n                                \"moduleCode\": 3,\n                                \"moduleId\": 49,\n                                \"approvalNumber\": 0,\n                                \"mark\": null,\n                                \"createTime\": \"2021-11-17 10:49:53.0\",\n                                \"updateTime\": null,\n                                \"isDelete\": false,\n                                \"subCommentList\": null,\n                                \"rootModuleCode\": 2,\n                                \"rootModuleId\": 7,\n                                \"rootCommentId\": 49,\n                                \"responseNumber\": 0\n                            },\n                            \"replyUser\": {\n                                \"userId\": 2,\n                                \"account\": \"qinshuo2\",\n                                \"password\": \"000000\",\n                                \"name\": \"秦硕\",\n                                \"sex\": 0,\n                                \"introduce\": null,\n                                \"address\": null,\n                                \"industry\": null,\n                                \"profession\": null,\n                                \"education\": null,\n                                \"authentication\": null,\n                                \"briefIntroduction\": null,\n                                \"headLogo\": \"http://10.12.0.158:8383/imagesUpload/b5abc5df-2f22-4449-ae80-1855977aaaa8.jpg\",\n                                \"followerNumber\": 3,\n                                \"mark\": null,\n                                \"createTime\": \"2021-11-05 21:24:17.0\",\n                                \"updateTime\": null,\n                                \"isDelete\": false\n                            },\n                            \"beRepliedUser\": {\n                                \"userId\": 1,\n                                \"account\": \"lihaopeng1\",\n                                \"password\": \"000000\",\n                                \"name\": \"李浩鹏\",\n                                \"sex\": 0,\n                                \"introduce\": null,\n                                \"address\": null,\n                                \"industry\": null,\n                                \"profession\": null,\n                                \"education\": null,\n                                \"authentication\": null,\n                                \"briefIntroduction\": null,\n                                \"headLogo\": \"http://10.12.0.158:8383/imagesUpload/ba784a17-8dd4-4ee3-896a-9b42f52d265c.jpg\",\n                                \"followerNumber\": 0,\n                                \"mark\": null,\n                                \"createTime\": \"2021-11-02 17:18:38.0\",\n                                \"updateTime\": null,\n                                \"isDelete\": false\n                            }\n                        },\n                        {\n                            \"comment\": {\n                                \"commentId\": 51,\n                                \"userId\": 3,\n                                \"commentContent\": \"用户3对评论49的回复\",\n                                \"moduleCode\": 3,\n                                \"moduleId\": 49,\n                                \"approvalNumber\": 0,\n                                \"mark\": null,\n                                \"createTime\": \"2021-11-17 10:51:55.0\",\n                                \"updateTime\": null,\n                                \"isDelete\": false,\n                                \"subCommentList\": null,\n                                \"rootModuleCode\": 2,\n                                \"rootModuleId\": 7,\n                                \"rootCommentId\": 49,\n                                \"responseNumber\": 0\n                            },\n                            \"replyUser\": {\n                                \"userId\": 3,\n                                \"account\": \"wangting3\",\n                                \"password\": \"000000\",\n                                \"name\": \"王婷\",\n                                \"sex\": 1,\n                                \"introduce\": null,\n                                \"address\": null,\n                                \"industry\": null,\n                                \"profession\": null,\n                                \"education\": null,\n                                \"authentication\": null,\n                                \"briefIntroduction\": null,\n                                \"headLogo\": \"http://10.12.0.158:8383/imagesUpload/9d7765b3-5489-47e8-9218-71c011e2bea1.jpg\",\n                                \"followerNumber\": 1,\n                                \"mark\": null,\n                                \"createTime\": \"2021-11-06 15:54:09.0\",\n                                \"updateTime\": null,\n                                \"isDelete\": false\n                            },\n                            \"beRepliedUser\": {\n                                \"userId\": 1,\n                                \"account\": \"lihaopeng1\",\n                                \"password\": \"000000\",\n                                \"name\": \"李浩鹏\",\n                                \"sex\": 0,\n                                \"introduce\": null,\n                                \"address\": null,\n                                \"industry\": null,\n                                \"profession\": null,\n                                \"education\": null,\n                                \"authentication\": null,\n                                \"briefIntroduction\": null,\n                                \"headLogo\": \"http://10.12.0.158:8383/imagesUpload/ba784a17-8dd4-4ee3-896a-9b42f52d265c.jpg\",\n                                \"followerNumber\": 0,\n                                \"mark\": null,\n                                \"createTime\": \"2021-11-02 17:18:38.0\",\n                                \"updateTime\": null,\n                                \"isDelete\": false\n                            }\n                        }\n                    ],\n                    \"rootModuleCode\": 2,\n                    \"rootModuleId\": 7,\n                    \"rootCommentId\": null,\n                    \"responseNumber\": 4\n                },\n                \"replyUser\": {\n                    \"userId\": 1,\n                    \"account\": \"lihaopeng1\",\n                    \"password\": \"000000\",\n                    \"name\": \"李浩鹏\",\n                    \"sex\": 0,\n                    \"introduce\": null,\n                    \"address\": null,\n                    \"industry\": null,\n                    \"profession\": null,\n                    \"education\": null,\n                    \"authentication\": null,\n                    \"briefIntroduction\": null,\n                    \"headLogo\": \"http://10.12.0.158:8383/imagesUpload/ba784a17-8dd4-4ee3-896a-9b42f52d265c.jpg\",\n                    \"followerNumber\": 0,\n                    \"mark\": null,\n                    \"createTime\": \"2021-11-02 17:18:38.0\",\n                    \"updateTime\": null,\n                    \"isDelete\": false\n                },\n                \"beRepliedUser\": null\n            },\n            {\n                \"comment\": {\n                    \"commentId\": 54,\n                    \"userId\": 3,\n                    \"commentContent\": \"用户4对回答7的评论\",\n                    \"moduleCode\": 2,\n                    \"moduleId\": 7,\n                    \"approvalNumber\": 0,\n                    \"mark\": null,\n                    \"createTime\": \"2021-11-17 19:07:02.0\",\n                    \"updateTime\": null,\n                    \"isDelete\": false,\n                    \"subCommentList\": [],\n                    \"rootModuleCode\": 2,\n                    \"rootModuleId\": 7,\n                    \"rootCommentId\": null,\n                    \"responseNumber\": 0\n                },\n                \"replyUser\": {\n                    \"userId\": 3,\n                    \"account\": \"wangting3\",\n                    \"password\": \"000000\",\n                    \"name\": \"王婷\",\n                    \"sex\": 1,\n                    \"introduce\": null,\n                    \"address\": null,\n                    \"industry\": null,\n                    \"profession\": null,\n                    \"education\": null,\n                    \"authentication\": null,\n                    \"briefIntroduction\": null,\n                    \"headLogo\": \"http://10.12.0.158:8383/imagesUpload/9d7765b3-5489-47e8-9218-71c011e2bea1.jpg\",\n                    \"followerNumber\": 1,\n                    \"mark\": null,\n                    \"createTime\": \"2021-11-06 15:54:09.0\",\n                    \"updateTime\": null,\n                    \"isDelete\": false\n                },\n                \"beRepliedUser\": null\n            }\n        ],\n        \"totalPages\": 1\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/CommentController.java",
    "groupTitle": "评论-Comment",
    "name": "GetCommentRoot_selectlistModulecode2Moduleid7Pagenumber1Pagelength10",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/comment/root_selectList?moduleCode=2&moduleId=7&pageNumber=1&pageLength=10"
      }
    ]
  },
  {
    "type": "post",
    "url": "/comment/add",
    "title": "添加评论",
    "version": "0.0.1",
    "description": "<p>在问题/回答/评论/文章/想法下添加评论</p>",
    "group": "评论-Comment",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>给与评论的用户id（系统生成唯一，在用户登录时返回），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "commentContent",
            "description": "<p>评论内容，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleCode",
            "description": "<p>评论针对的对象类型，1：problem；2：answer；3：comment；4：article；5：idea；必填。PS：针对回答和文章做评论时，需要查阅评论权限再提交评论。</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "moduleId",
            "description": "<p>评论所针对的对象的id，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "rootModuleCode",
            "description": "<p>评论的源头类型：1：problem；2：answer；3：article；4：idea；用于评论计数，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "rootModuleId",
            "description": "<p>评论的源头id，用于评论计数，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "rootCommentId",
            "description": "<p>根评论id，用于回复计数，当评论为回复类型时，必填</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"userId\": 3,\n    \"commentContent\": \"用户3对评论50的回复\",\n    \"moduleCode\": 3,\n    \"moduleId\": 50,\n    \"rootModuleCode\": 1,\n    \"rootModuleId\": 1,\n    \"rootCommentId\": 49\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；1201-缺少评论的源头类型；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>添加对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"添加成功\",\n    \"data\": {\n        \"commentId\": 52,\n        \"userId\": 3,\n        \"commentContent\": \"用户3对评论50的回复\",\n        \"moduleCode\": 3,\n        \"moduleId\": 50,\n        \"approvalNumber\": null,\n        \"mark\": null,\n        \"createTime\": \"2021-11-17 10:52:49\",\n        \"updateTime\": null,\n        \"isDelete\": null,\n        \"subCommentList\": null,\n        \"rootModuleCode\": 1,\n        \"rootModuleId\": 1,\n        \"rootCommentId\": 49,\n        \"responseNumber\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/CommentController.java",
    "groupTitle": "评论-Comment",
    "name": "PostCommentAdd",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/comment/add"
      }
    ]
  },
  {
    "type": "get",
    "url": "/invite/selectList?inviterId=1&problemId=1",
    "title": "查询邀请",
    "version": "0.0.1",
    "description": "<p>邀请回答之查询用户对此问题邀请了哪些人</p>",
    "group": "邀请回答-ProblemInvitation",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "inviterId",
            "description": "<p>邀请者(对应userId），必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "problemId",
            "description": "<p>问题id，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>查询列表</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"problemInvitationList\": [\n            {\n                \"questionsInviteesId\": 1,\n                \"problemId\": 1,\n                \"inviterId\": 1,\n                \"inviteeId\": 2,\n                \"updateTime\": \"2021-11-09 15:59:09.0\",\n                \"isDelete\": false\n            },\n            {\n                \"questionsInviteesId\": 2,\n                \"problemId\": 1,\n                \"inviterId\": 1,\n                \"inviteeId\": 3,\n                \"updateTime\": \"2021-11-09 17:06:52.0\",\n                \"isDelete\": false\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/ProblemInvitationController.java",
    "groupTitle": "邀请回答-ProblemInvitation",
    "name": "GetInviteSelectlistInviterid1Problemid1",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/invite/selectList?inviterId=1&problemId=1"
      }
    ]
  },
  {
    "type": "post",
    "url": "/invite/add",
    "title": "添加邀请",
    "version": "0.0.1",
    "description": "<p>邀请回答之添加邀请接口</p>",
    "group": "邀请回答-ProblemInvitation",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "problemId",
            "description": "<p>问题id，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "inviterId",
            "description": "<p>邀请者(对应userId），必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "inviteeId",
            "description": "<p>被邀请者（对应userId），必填</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"problemId\": 1,\n    \"inviterId\": 1,\n    \"inviteeId\": 2\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>添加对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"添加成功\",\n    \"data\": {\n        \"questionsInviteesId\": 1,\n        \"problemId\": 1,\n        \"inviterId\": 1,\n        \"inviteeId\": 2,\n        \"updateTime\": \"2021-11-09 15:59:09\",\n        \"isDelete\": null\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/ProblemInvitationController.java",
    "groupTitle": "邀请回答-ProblemInvitation",
    "name": "PostInviteAdd",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/invite/add"
      }
    ]
  },
  {
    "type": "get",
    "url": "/problem/select?problemId=5",
    "title": "查询某问题",
    "version": "0.0.1",
    "description": "<p>根据问题id获取该问题的所有信息</p>",
    "group": "问题-Problem",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "problemId",
            "description": "<p>问题id，必填</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>查询对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功\",\n    \"data\": {\n        \"problemId\": 5,\n        \"userId\": 2,\n        \"problemDescribe\": \"有JAVA基础，学习前端需要多久？\",\n        \"problemDetails\": \"<p>xxx</p >\",\n        \"browseNumber\": 0,\n        \"followerNumber\": 0,\n        \"goodQuestionNumber\": 10,\n        \"commentNumber\": 0,\n        \"answerNumber\": 0,\n        \"isAnonymity\": true,\n        \"mark\": null,\n        \"createTime\": \"2021-11-04 23:20:03.0\",\n        \"updateTime\": null,\n        \"isDelete\": false,\n        \"abbreviatedContent\": \"xxx\",\n        \"tagList\": [\n            {\n                \"tagId\": 1\n            },\n            {\n                \"tagId\": 2\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/ProblemController.java",
    "groupTitle": "问题-Problem",
    "name": "GetProblemSelectProblemid5",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/problem/select?problemId=5"
      }
    ]
  },
  {
    "type": "get",
    "url": "/problem/selectList?category=1&pageNumber=1&pageLength=2&userId=",
    "title": "等你来答",
    "version": "0.0.1",
    "description": "<p>根据分类分页获取平台所有相关分类问题</p>",
    "group": "问题-Problem",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "category",
            "description": "<p>问题分类，1：人气问题；查询规则为：问题的关注人数+认为是好问题的人数+问题的评论个数+问题的回答个数的总和从高到低排序。 2：最新问题；查询规则为：发布时间。 3：邀请回答；为邀请回答的问题，根据用户id查询。</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageNumber",
            "description": "<p>页码，必填</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "pageLength",
            "description": "<p>页面长度，必填，唯一限定某一值</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id，查询该用户被邀请回答的问题(category=3)时使用，否则为null，即&amp;userId=。返回的是邀请关系，再调用查询某问题接口显示问题详情。</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-查询成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "problemList/problemInvitationList",
            "description": "<p>回答列表/邀请关系列表</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功：页码1包含的所有问题信息\",\n    \"data\": {\n        \"problemList\": [\n            {\n                \"problemId\": 1,\n                \"userId\": 1,\n                \"problemDescribe\": \"有JAVA基础，学习前端需要多久？\",\n                \"problemDetails\": \"<p>xxx</p >\",\n                \"browseNumber\": 0,\n                \"followerNumber\": 0,\n                \"goodQuestionNumber\": 5,\n                \"commentNumber\": 0,\n                \"answerNumber\": 10,\n                \"isAnonymity\": true,\n                \"mark\": null,\n                \"createTime\": \"2021-11-04 15:49:55.0\",\n                \"updateTime\": null,\n                \"isDelete\": false,\n                \"abbreviatedContent\": \"xxx\",\n                \"tagList\": null\n            },\n            {\n                \"problemId\": 5,\n                \"userId\": 2,\n                \"problemDescribe\": \"有JAVA基础，学习前端需要多久？\",\n                \"problemDetails\": \"<p>xxx</p >\",\n                \"browseNumber\": 0,\n                \"followerNumber\": 0,\n                \"goodQuestionNumber\": 10,\n                \"commentNumber\": 0,\n                \"answerNumber\": 0,\n                \"isAnonymity\": true,\n                \"mark\": null,\n                \"createTime\": \"2021-11-04 23:20:03.0\",\n                \"updateTime\": null,\n                \"isDelete\": false,\n                \"abbreviatedContent\": \"xxx\",\n                \"tagList\": null\n            }\n        ]\n    }\n}",
          "type": "json"
        },
        {
          "title": "返回成功样例（某用户被邀请回答的关系）：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"查询成功：页码1包含的邀请回答信息\",\n    \"data\": {\n        \"problemInvitationList\": [\n            {\n                \"questionsInviteesId\": 1,\n                \"problemId\": 1,\n                \"inviterId\": 1,\n                \"inviteeId\": 2,\n                \"updateTime\": \"2021-11-09 15:59:09.0\",\n                \"isDelete\": false\n            },\n            {\n                \"questionsInviteesId\": 3,\n                \"problemId\": 2,\n                \"inviterId\": 1,\n                \"inviteeId\": 2,\n                \"updateTime\": null,\n                \"isDelete\": false\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/ProblemController.java",
    "groupTitle": "问题-Problem",
    "name": "GetProblemSelectlistCategory1Pagenumber1Pagelength2Userid",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/problem/selectList?category=1&pageNumber=1&pageLength=2&userId="
      }
    ]
  },
  {
    "type": "post",
    "url": "/problem/add",
    "title": "提交问题",
    "version": "0.0.1",
    "description": "<p>用户提交问题的接口</p>",
    "group": "问题-Problem",
    "parameter": {
      "fields": {
        "入参": [
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>提问题的用户id（系统生成唯一，用户登录时返回），必填</p>"
          },
          {
            "group": "入参",
            "type": "String",
            "optional": false,
            "field": "problemDescribe",
            "description": "<p>问题描述，带问号</p>"
          },
          {
            "group": "入参",
            "type": "text",
            "optional": false,
            "field": "problemDetails",
            "description": "<p>输入问题背景、条件等详细信息（选填）</p>"
          },
          {
            "group": "入参",
            "type": "text",
            "optional": false,
            "field": "abbreviatedContent",
            "description": "<p>收起的缩略内容</p>"
          },
          {
            "group": "入参",
            "type": "array",
            "optional": false,
            "field": "tagList",
            "description": "<p>标签列表，至少带一个，带的话题是个标签，所属分类是话题</p>"
          },
          {
            "group": "入参",
            "type": "int",
            "optional": false,
            "field": "tagId",
            "description": "<p>标签Id，值列表，需数据库中拥有。</p>"
          },
          {
            "group": "入参",
            "type": "boolean",
            "optional": false,
            "field": "isAnonymity",
            "description": "<p>问题发布者是否匿名，0代表不生效（默认），1代表生效</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "入参样例：",
          "content": "{\n    \"userId\": 1,\n    \"problemDescribe\": \"有JAVA基础，学习前端需要多久？\",\n    \"problemDetails\": \"<p>xxx</p >\",\n    \"abbreviatedContent\": \"xxx\",\n    \"tagList\": [\n            {\n                \"tagId\": 1\n            },\n            {\n                 \"tagId\": 2\n            }\n        ],\n    \"isAnonymity\": 1\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "出参": [
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Code",
            "description": "<p>接口返回编码；200-添加成功；2001-数据库执行有异常；</p>"
          },
          {
            "group": "出参",
            "type": "String",
            "optional": false,
            "field": "Message",
            "description": "<p>消息描述</p>"
          },
          {
            "group": "出参",
            "type": "object",
            "optional": false,
            "field": "data",
            "description": "<p>添加对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回成功样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"添加成功\",\n    \"data\": {\n        \"problemId\": 5,\n        \"userId\": 1,\n        \"problemDescribe\": \"有JAVA基础，学习前端需要多久？\",\n        \"problemDetails\": \"<p>xxx</p >\",\n        \"browseNumber\": null,\n        \"followerNumber\": null,\n        \"goodQuestionNumber\": null,\n        \"commentNumber\": null,\n        \"answerNumber\": null,\n        \"isAnonymity\": true,\n        \"mark\": null,\n        \"createTime\": \"2021-11-04 23:20:03\",\n        \"updateTime\": null,\n        \"isDelete\": null,\n        \"abbreviatedContent\": \"xxx\",\n        \"tagList\": [\n            {\n                \"tagId\": 1\n            },\n            {\n                \"tagId\": 2\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "返回失败样例：",
          "content": "{\n    \"code\": 2001,\n    \"message\": \"数据库执行有异常\",\n    \"data\": null\n}",
          "type": "json"
        }
      ]
    },
    "filename": "exchange_q_a/function-development/src/main/java/cn/edu/guet/exchange/controller/ProblemController.java",
    "groupTitle": "问题-Problem",
    "name": "PostProblemAdd",
    "sampleRequest": [
      {
        "url": "http://10.12.0.158:8246/problem/add"
      }
    ]
  }
] });
