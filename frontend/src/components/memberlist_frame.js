import { useEffect, useState, useRef } from "react";
import { renderToString } from 'react-dom/server';

import axios from "axios";

import "./components.module.css";
import { MemberlistMember } from "./memberlist_member.js";

export function MemberlistFrame() {
    
    const member_table_body = useRef()

    const [cur_page, setCurPage] = useState(1);
    const [member_list, setMemberList] = useState([]);

    function getMemberList() {
        // let url = "/api/member/" + cur_page;
        let url = 'https://jsonplaceholder.typicode.com/users';

        // temporary code for test
        axios.get(url)
            .then((res) => {
                setMemberList([...res.data]);
            })
            .catch((e) => {
                console.log(e)
            });
        // temporary code for test
    }

    useEffect(() => {
        getMemberList(cur_page);
    }, []);

    useEffect(() => {
        if (0 < member_list.length) {
            let member_row = (
                <tbody>
                    {
                        member_list.map((x) => {
                            return (
                                <MemberlistMember member={x} />
                            )
                        })
                    }
                </tbody>
            );

            member_table_body.current.outerHTML = renderToString(member_row);
        }
    }, [member_list]);

    return (
        <div>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Grade</th>
                </tr>
                </thead>
                <tbody ref={member_table_body} />
            </table>
        </div>
    );
}