import { useEffect, useState, useRef } from "react";

import axios from "axios";

import { Memberlist_member } from "./memberlist_member.js";

export function Memberlist_frame() {
    
    const member_table_body = useRef()

    const [cur_page, setCurPage] = useState(1);
    const [member_list, setMemberList] = useState([]);

    function getMemberList() {
        let url = "/api/member/" + cur_page;
        let result = null;

        // temporary code for test
        result = [];
        result.push({
            'id': '',
            'username': '',
            'Grade': 'Administrator'
        })
        // temporary code for test

        setMemberList(result);
    }

    useEffect(() => {
        getMemberList(cur_page);
    }, []);

    useEffect(() => {
        // TODO: React ref에 tr 추가하는 법 확인 필요
        // member_table_body.current.
    }, member_list);

    return (
        <div className="memberlist_frame">
            <table className="table">
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