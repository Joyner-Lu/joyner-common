package com.joyner.common.xpath;

import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.Reader;
import java.io.StringReader;

public class TestXpath {

    @Test
    public void testDemo1() throws Exception {
        String xml = getXMLContent();
        Document document = parse(xml);
        Element root = document.getRootElement();
        Element body = root.element("body");
        String bodyText = body.getText();
        System.out.println(bodyText);
    }

    public String getXMLContent () {
        String xml =
                "<service\n" +
                "    xmlns=\"http://www.chinatax.gov.cn/spec/\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "    <head>\n" +
                "        <tran_id>00.FP.FPXX.DZSWJCX.FPTBRWTJ</tran_id>\n" +
                "        <channel_id>GDGS.NFWB.DZSWJ</channel_id>\n" +
                "        <tran_seq>frse60454730081471002019062575239880</tran_seq>\n" +
                "        <tran_date>20190624</tran_date>\n" +
                "        <tran_time>144638624</tran_time>\n" +
                "        <rtn_code>0</rtn_code>\n" +
                "        <rtn_msg>\n" +
                "            <Code>000</Code>\n" +
                "            <Message>\n" +
                "                <![CDATA[]]>\n" +
                "            </Message>\n" +
                "            <Reason>\n" +
                "                <![CDATA[]]>\n" +
                "            </Reason>\n" +
                "        </rtn_msg>\n" +
                "        <expand>\n" +
                "            <name>sjjg</name>\n" +
                "            <value>null</value>\n" +
                "        </expand>\n" +
                "        <expand>\n" +
                "            <name>identityType</name>\n" +
                "            <value>GDGS.NFWB.DZSWJ</value>\n" +
                "        </expand>\n" +
                "        <expand>\n" +
                "            <name>sjry</name>\n" +
                "            <value>14400dzswj0</value>\n" +
                "        </expand>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <![CDATA[{\"resultCount\":\"0\",\"code\":200,\"compressionFlag\":\"false\",\"maxReturnCount\":\"0\",\"message\":\"操作成功\",\"body\":{\"msg\":\"ok\",\"code\":\"200\",\"data\":[{\"cost\":232,\"optimizer\":\"ALL_ROWS\",\"bytes\":11554,\"description\":\"   SELECT STATEMENT \",\"ioCost\":232,\"cpuCost\":1671846,\"operation\":\"SELECT STATEMENT\",\"cardinality\":53},{\"description\":\"      FILTER \",\"operation\":\"FILTER\"},{\"cost\":232,\"bytes\":11554,\"description\":\"         NESTED LOOPS \",\"ioCost\":232,\"cpuCost\":1671846,\"operation\":\"NESTED LOOPS\",\"cardinality\":53},{\"cost\":232,\"bytes\":11554,\"description\":\"            NESTED LOOPS \",\"ioCost\":232,\"cpuCost\":1671846,\"operation\":\"NESTED LOOPS\",\"cardinality\":53},{\"partitionStart\":\"496\",\"cost\":20,\"partitionStop\":\"496\",\"bytes\":2862,\"options\":\"SINGLE\",\"description\":\"               PARTITION RANGE SINGLE\",\"ioCost\":20,\"cpuCost\":206167,\"operation\":\"PARTITION RANGE\",\"cardinality\":53},{\"partitionStart\":\"496\",\"cost\":20,\"partitionStop\":\"496\",\"description\":\"                  TABLE ACCESS BY LOCAL INDEX ROWID\",\"objectOwner\":\"DZDZ\",\"cpuCost\":206167,\"cardinality\":53,\"optimizer\":\"ANALYZED\",\"bytes\":2862,\"options\":\"BY LOCAL INDEX ROWID\",\"objectName\":\"DZDZ_FPXX_PTFP\",\"ioCost\":20,\"operation\":\"TABLE ACCESS\"},{\"partitionStart\":\"496\",\"cost\":4,\"partitionStop\":\"496\",\"description\":\"                     INDEX RANGE SCAN\",\"objectOwner\":\"DZDZ\",\"cpuCost\":39486,\"cardinality\":55,\"optimizer\":\"ANALYZED\",\"options\":\"RANGE SCAN\",\"objectName\":\"IDX_DZDZ_FPXX_PTFP_GFSBH\",\"ioCost\":4,\"operation\":\"INDEX\",\"accessPredicates\":\"\\\"FP\\\".\\\"XFSBH\\\"='91441300744450119Y'\"},{\"partitionStart\":\"496\",\"cost\":3,\"partitionStop\":\"496\",\"options\":\"SINGLE\",\"description\":\"               PARTITION RANGE SINGLE\",\"ioCost\":3,\"cpuCost\":22464,\"operation\":\"PARTITION RANGE\",\"cardinality\":1},{\"partitionStart\":\"496\",\"cost\":3,\"partitionStop\":\"496\",\"description\":\"                  INDEX RANGE SCAN\",\"objectOwner\":\"DZDZ\",\"cpuCost\":22464,\"cardinality\":1,\"optimizer\":\"ANALYZED\",\"options\":\"RANGE SCAN\",\"objectName\":\"PK_DZDZ_HWXX_PTFP\",\"ioCost\":3,\"operation\":\"INDEX\",\"accessPredicates\":\"\\\"FP\\\".\\\"FPDM\\\"=\\\"HW\\\".\\\"FPDM\\\" AND \\\"FP\\\".\\\"FPHM\\\"=\\\"HW\\\".\\\"FPHM\\\" AND \\\"HW\\\".\\\"KPYF\\\"=201904\"},{\"partitionStart\":\"496\",\"cost\":4,\"partitionStop\":\"496\",\"description\":\"            TABLE ACCESS BY LOCAL INDEX ROWID\",\"objectOwner\":\"DZDZ\",\"cpuCost\":27654,\"cardinality\":1,\"optimizer\":\"ANALYZED\",\"bytes\":164,\"options\":\"BY LOCAL INDEX ROWID\",\"objectName\":\"DZDZ_HWXX_PTFP\",\"ioCost\":4,\"operation\":\"TABLE ACCESS\"}],\"plan\":\"ZGVzY3JpcHRpb24gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCBvYmplY3RPd25lciAgIHwgb2JqZWN0TmFtZSAgICAgICAgICAgICAgICAgfCBjb3N0ICAgfCBjYXJkaW5hbGl0eSAgIHwgYnl0ZXMgICB8IGlvQ29zdCAgIHwgcGFydGl0aW9uU3RhcnQgICB8IHBhcnRpdGlvblN0b3AgICB8IGNwdUNvc3QgICB8IG9wdGltaXplciAgIHwgYWNjZXNzUHJlZGljYXRlcyAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgU0VMRUNUIFNUQVRFTUVOVCAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAgICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAyMzIgICAgfCA1MyAgICAgICAgICAgIHwgMTE1NTQgICB8IDIzMiAgICAgIHwgICAgICAgICAgICAgICAgICB8ICAgICAgICAgICAgICAgICB8IDE2NzE4NDYgICB8IEFMTF9ST1dTICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgRklMVEVSICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAgICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAgICAgICAgfCAgICAgICAgICAgICAgIHwgICAgICAgICB8ICAgICAgICAgIHwgICAgICAgICAgICAgICAgICB8ICAgICAgICAgICAgICAgICB8ICAgICAgICAgICB8ICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgTkVTVEVEIExPT1BTICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAgICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAyMzIgICAgfCA1MyAgICAgICAgICAgIHwgMTE1NTQgICB8IDIzMiAgICAgIHwgICAgICAgICAgICAgICAgICB8ICAgICAgICAgICAgICAgICB8IDE2NzE4NDYgICB8ICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgTkVTVEVEIExPT1BTICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAgICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAyMzIgICAgfCA1MyAgICAgICAgICAgIHwgMTE1NTQgICB8IDIzMiAgICAgIHwgICAgICAgICAgICAgICAgICB8ICAgICAgICAgICAgICAgICB8IDE2NzE4NDYgICB8ICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgUEFSVElUSU9OIFJBTkdFIFNJTkdMRSAgICAgICAgICAgICAgICAgfCAgICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAyMCAgICAgfCA1MyAgICAgICAgICAgIHwgMjg2MiAgICB8IDIwICAgICAgIHwgNDk2ICAgICAgICAgICAgICB8IDQ5NiAgICAgICAgICAgICB8IDIwNjE2NyAgICB8ICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgVEFCTEUgQUNDRVNTIEJZIExPQ0FMIElOREVYIFJPV0lEICAgfCBEWkRaICAgICAgICAgIHwgRFpEWl9GUFhYX1BURlAgICAgICAgICAgICAgfCAyMCAgICAgfCA1MyAgICAgICAgICAgIHwgMjg2MiAgICB8IDIwICAgICAgIHwgNDk2ICAgICAgICAgICAgICB8IDQ5NiAgICAgICAgICAgICB8IDIwNjE2NyAgICB8IEFOQUxZWkVEICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgSU5ERVggUkFOR0UgU0NBTiAgICAgICAgICAgICAgICAgfCBEWkRaICAgICAgICAgIHwgSURYX0RaRFpfRlBYWF9QVEZQX0dGU0JIICAgfCA0ICAgICAgfCA1NSAgICAgICAgICAgIHwgICAgICAgICB8IDQgICAgICAgIHwgNDk2ICAgICAgICAgICAgICB8IDQ5NiAgICAgICAgICAgICB8IDM5NDg2ICAgICB8IEFOQUxZWkVEICAgIHwgIkZQIi4iWEZTQkgiPSc5MTQ0MTMwMDc0NDQ1MDExOVknICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgUEFSVElUSU9OIFJBTkdFIFNJTkdMRSAgICAgICAgICAgICAgICAgfCAgICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgfCAzICAgICAgfCAxICAgICAgICAgICAgIHwgICAgICAgICB8IDMgICAgICAgIHwgNDk2ICAgICAgICAgICAgICB8IDQ5NiAgICAgICAgICAgICB8IDIyNDY0ICAgICB8ICAgICAgICAgICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgSU5ERVggUkFOR0UgU0NBTiAgICAgICAgICAgICAgICAgICAgfCBEWkRaICAgICAgICAgIHwgUEtfRFpEWl9IV1hYX1BURlAgICAgICAgICAgfCAzICAgICAgfCAxICAgICAgICAgICAgIHwgICAgICAgICB8IDMgICAgICAgIHwgNDk2ICAgICAgICAgICAgICB8IDQ5NiAgICAgICAgICAgICB8IDIyNDY0ICAgICB8IEFOQUxZWkVEICAgIHwgIkZQIi4iRlBETSI9IkhXIi4iRlBETSIgQU5EICJGUCIuIkZQSE0iPSJIVyIuIkZQSE0iIEFORCAiSFciLiJLUFlGIj0yMDE5MDQgICAKICAgICAgICAgICAgVEFCTEUgQUNDRVNTIEJZIExPQ0FMIElOREVYIFJPV0lEICAgICAgICAgfCBEWkRaICAgICAgICAgIHwgRFpEWl9IV1hYX1BURlAgICAgICAgICAgICAgfCA0ICAgICAgfCAxICAgICAgICAgICAgIHwgMTY0ICAgICB8IDQgICAgICAgIHwgNDk2ICAgICAgICAgICAgICB8IDQ5NiAgICAgICAgICAgICB8IDI3NjU0ICAgICB8IEFOQUxZWkVEICAgIHwgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAK\"}}]]>\n" +
                "    </body>\n" +
                "</service>";
        return xml;
    }

    public Document parse(String xmlContent) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Reader reader = new StringReader(xmlContent);
        Document document = saxReader.read(reader);
        return document;
    }
}
