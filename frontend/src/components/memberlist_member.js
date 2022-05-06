import "./components.module.css";

export function MemberlistMember({member}) {
    return (
        <div>
            <tr>
                <td>{member.id}</td>
                <td>{member.name}</td>
                <td>{member.website}</td>
            </tr>
        </div>
    );
}