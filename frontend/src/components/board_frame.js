import { useEffect, useState, useRef } from "react";
import { renderToString } from 'react-dom/server';

import axios from "axios";

import "./components.module.css";
import { BoardArticle } from "./board_article.js";

export function BoardFrame() {

    const article_table_body = useRef();

    const [cur_page, setCurPage] = useState(1);
    const [article_list, setArticleList] = useState([]);

    function getArticleList() {
        // for test
        let url = 'https://jsonplaceholder.typicode.com/posts';

        // temporary code for test
        axios.get(url)
            .then((res) => {
                setArticleList([...res.data]);
            })
            .catch((e) => {
                console.log(e);
            });
        // temporary code for test
    }

    useEffect(() => {
        getArticleList(cur_page);
    }, [null, cur_page]);

    useEffect(() => {
        if (0 < article_list.length) {
            let article_tbody = (
                <tbody>
                    {
                        article_list.map((x) => {
                            return (
                                <BoardArticle article={x} />
                            );
                        })
                    }
                </tbody>
            );

            article_table_body.current.outerHTML = renderToString(article_tbody);
        }
    }, [article_list]);

    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Title</td>
                        <td>Member</td>
                        <td>ID</td>
                    </tr>
                </thead>
                <tbody ref={article_table_body} />
            </table>
        </div>
    );
}