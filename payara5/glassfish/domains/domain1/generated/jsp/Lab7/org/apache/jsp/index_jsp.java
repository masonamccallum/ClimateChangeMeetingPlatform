package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"lab.css\">\n");
      out.write("        <title>Book Catalog</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"banner\">\n");
      out.write("            <div class=\"banner-text\">\n");
      out.write("                <h2>Book Catalog</h2>\n");
      out.write("            </div>     \n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"centered-p\">\n");
      out.write("        Welcome! Have a look at the books in my catalog. You can add books by \n");
      out.write("        filling out the first row within the table or by filling out the form\n");
      out.write("        at the bottom of the page. To remove a book, simply click on the \n");
      out.write("        <b>Remove</b> button next to that book.\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <table id=\"books\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Title</th>\n");
      out.write("                <th>Author</th>\n");
      out.write("                <th>Year</th>\n");
      out.write("                <th>Pages</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("            </tr>\n");
      out.write("            <form id=\"add-form\" action=\"BookController\" method=\"post\">\n");
      out.write("            <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" size=\"15\" name=\"title\" id=\"title-input\" class=\"valid-input\">\n");
      out.write("                        <div id=\"title-required-text\" class=\"invalid-text-hidden\">* Required</div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" size=\"10\" name=\"author\" id=\"author-input\" class=\"valid-input\">\n");
      out.write("                        <div id=\"author-required-text\" class=\"invalid-text-hidden\">* Required</div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" size=\"5\" name=\"year\" id=\"year-input\" class=\"valid-input\">\n");
      out.write("                        <div id=\"year-required-text\" class=\"invalid-text-hidden\">*Required</div>\n");
      out.write("                        <div id=\"year-invalid-text\" class=\"invalid-text-hidden\">*Numbers Only</div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" size=\"5\" name=\"pages\" id=\"pages-input\" class=\"valid-input\">\n");
      out.write("                        <div id=\"pages-required-text\" class=\"invalid-text-hidden\">*Required</div>\n");
      out.write("                        <div id=\"pages-invalid-text\" class=\"invalid-text-hidden\">*Numbers Only</div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        $  \n");
      out.write("                        <input type=\"text\" size=\"5\" name=\"price\" id=\"price-input\" class=\"valid-input\">\n");
      out.write("                        <div id=\"price-required-text\" class=\"invalid-text-hidden\">*Required</div>\n");
      out.write("                        <div id=\"price-invalid-text\" class=\"invalid-text-hidden\">*Numbers Only</div>\n");
      out.write("                    </td>\n");
      out.write("                    <td class=\"add-cell\">\n");
      out.write("                        <input type=\"hidden\" name=\"add\" value=\"true\">\n");
      out.write("                        <input id=\"add\" type=\"submit\" value=\"Add\" class=\"add-button\">\n");
      out.write("                    </td> \n");
      out.write("            </tr>\n");
      out.write("            </form>\n");
      out.write("            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            function checkTitle() {\n");
      out.write("                if( !$(\"#title-input\").val())\n");
      out.write("                {\n");
      out.write("                    $(\"#title-input\").attr(\"class\", \"invalid-input\");\n");
      out.write("                    $(\"#title-required-text\").attr(\"class\",\"invalid-text-visible\");\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    $(\"#title-input\").attr(\"class\", \"valid-input\");\n");
      out.write("                    $(\"#title-required-text\").attr(\"class\",\"invalid-text-hidden\");\n");
      out.write("                    return true;\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function checkAuthor() {\n");
      out.write("                if( !$(\"#author-input\").val())\n");
      out.write("                {\n");
      out.write("                    $(\"#author-input\").attr(\"class\", \"invalid-input\");\n");
      out.write("                    $(\"#author-required-text\").attr(\"class\",\"invalid-text-visible\");\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    $(\"#author-input\").attr(\"class\", \"valid-input\");\n");
      out.write("                    $(\"#author-required-text\").attr(\"class\",\"invalid-text-hidden\");\n");
      out.write("                    return true;\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function checkYear() {\n");
      out.write("                hideR = true;\n");
      out.write("                hideI = true;\n");
      out.write("                submit = true;\n");
      out.write("                if( !$(\"#year-input\").val())\n");
      out.write("                {\n");
      out.write("                    $(\"#year-input\").attr(\"class\", \"invalid-input\");\n");
      out.write("                    $(\"#year-required-text\").attr(\"class\",\"invalid-text-visible\");\n");
      out.write("                    hideR = false;\n");
      out.write("                    submit = false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if (isNaN($(\"#year-input\").val())){\n");
      out.write("                    $(\"#year-input\").attr(\"class\", \"invalid-input\");\n");
      out.write("                    $(\"#year-invalid-text\").attr(\"class\",\"invalid-text-visible\");\n");
      out.write("                    hideI = false;\n");
      out.write("                    submit = false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(hideR) {\n");
      out.write("                    $(\"#year-required-text\").attr(\"class\",\"invalid-text-hidden\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(hideI) {\n");
      out.write("                    $(\"#year-invalid-text\").attr(\"class\",\"invalid-text-hidden\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(submit) {\n");
      out.write("                    $(\"#year-input\").attr(\"class\", \"valid-input\");\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    return false;\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function checkPages() {\n");
      out.write("                hideR = true;\n");
      out.write("                hideI = true;\n");
      out.write("                submit = true;\n");
      out.write("                if( !$(\"#pages-input\").val())\n");
      out.write("                {\n");
      out.write("                    $(\"#pages-input\").attr(\"class\", \"invalid-input\");\n");
      out.write("                    $(\"#pages-required-text\").attr(\"class\",\"invalid-text-visible\");\n");
      out.write("                    hideR = false;\n");
      out.write("                    submit = false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if (isNaN($(\"#pages-input\").val())){\n");
      out.write("                    $(\"#pages-input\").attr(\"class\", \"invalid-input\");\n");
      out.write("                    $(\"#pages-invalid-text\").attr(\"class\",\"invalid-text-visible\");\n");
      out.write("                    hideI = false;\n");
      out.write("                    submit = false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(hideR) {\n");
      out.write("                    $(\"#pages-required-text\").attr(\"class\",\"invalid-text-hidden\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(hideI) {\n");
      out.write("                    $(\"#pages-invalid-text\").attr(\"class\",\"invalid-text-hidden\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(submit) {\n");
      out.write("                    $(\"#pages-input\").attr(\"class\", \"valid-input\");\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    return false;\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function checkPrice() {\n");
      out.write("                hideR = true;\n");
      out.write("                hideI = true;\n");
      out.write("                submit = true;\n");
      out.write("                if( !$(\"#price-input\").val())\n");
      out.write("                {\n");
      out.write("                    $(\"#price-input\").attr(\"class\", \"invalid-input\");\n");
      out.write("                    $(\"#price-required-text\").attr(\"class\",\"invalid-text-visible\");\n");
      out.write("                    hideR = false;\n");
      out.write("                    submit = false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if (isNaN($(\"#price-input\").val())){\n");
      out.write("                    $(\"#price-input\").attr(\"class\", \"invalid-input\");\n");
      out.write("                    $(\"#price-invalid-text\").attr(\"class\",\"invalid-text-visible\");\n");
      out.write("                    hideI = false;\n");
      out.write("                    submit = false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(hideR) {\n");
      out.write("                    $(\"#price-required-text\").attr(\"class\",\"invalid-text-hidden\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(hideI) {\n");
      out.write("                    $(\"#price-invalid-text\").attr(\"class\",\"invalid-text-hidden\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(submit) {\n");
      out.write("                    $(\"#price-input\").attr(\"class\", \"valid-input\");\n");
      out.write("                    return true;\n");
      out.write("                } else {\n");
      out.write("                    return false;\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            $(\"#add-form\").submit( function (event) {\n");
      out.write("                \n");
      out.write("                s = 0;\n");
      out.write("                \n");
      out.write("                if(!checkTitle()){\n");
      out.write("                    console.log(\"Invalid title\");\n");
      out.write("                    s += 1;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(!checkAuthor()) {\n");
      out.write("                    console.log(\"Invalid author\");\n");
      out.write("                    s += 1;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(!checkYear()) {\n");
      out.write("                    console.log(\"Invalid year\");\n");
      out.write("                    s += 1;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(!checkPages()) {\n");
      out.write("                    console.log(\"Invalid pages\");\n");
      out.write("                    s += 1;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(!checkPrice()) {\n");
      out.write("                    console.log(\"Invalid price\");\n");
      out.write("                    s += 1;\n");
      out.write("                }\n");
      out.write("               \n");
      out.write("                return s === 0;\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("book");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${books}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <tr>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.author}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.year}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.pages}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td>$  ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td class=\"remove-cell\">\n");
          out.write("                        <form action=\"BookController\" method=\"post\">\n");
          out.write("                        <input type=\"hidden\" name=\"uuid\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                        <input type=\"hidden\" name=\"add\" vale=\"false\">\n");
          out.write("                        <input type=\"submit\" value=\"Remove\" class=\"remove-button\">\n");
          out.write("                        </form>\n");
          out.write("                    </td>\n");
          out.write("                    \n");
          out.write("                </tr>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
