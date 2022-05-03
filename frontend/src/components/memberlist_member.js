import { useEffect } from "react";

export function Memberlist_member({member}) {

    // props로 아래 내용 채우자

    return (
        <div className="memberlist_member">
            <tr>
                <td>{member.id}</td>
                <td>{member.username}</td>
                <td>{member.grade}</td>
            </tr>
        </div>
    );
}