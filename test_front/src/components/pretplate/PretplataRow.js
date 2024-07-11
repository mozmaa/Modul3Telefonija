import { Button } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import TestAxios from "../../apis/TestAxios"

export const PretplataRow = (props) => {
    console.log(props)
    const navigate = useNavigate()
    const isZaduzeniUser = (props.loginInfo?.name)?.toUpperCase() === (props.pretplata.imeKorisnika).toUpperCase()

    const goToEdit = (pretplata) =>{
        props.editCallback(pretplata)
        navigate('/pretplata/edit')
    }

    const deletePretplata = (id) => {
        TestAxios.delete('/pretplate/' + id)
            .then(res => {
                alert ('Uspesno brisanje')
                props.deleteCallback((pretplate)=>pretplate.filter(pretplate => pretplate.id !== id))
                if(props.pretplate.length === 1){
                    props.getPretplateCallback(props.pageNo-1)
                }
            }).catch(error => {
                alert('Doslo je do greske prilikom brisanja')
            })
    }

    let tryInfo = isZaduzeniUser ?  false : props.loginInfo?.isAdmin ? false : true

    return (
        <tr key={props.pretplata.id}>
            <td>{props.pretplata.imeKorisnika}</td>
            <td>{props.pretplata.provajderIme}</td>
            <td>{props.pretplata.tarifaIme}</td>
            <td>{props.pretplata.cena}</td>
            <td>{props.pretplata.datumPocetka}</td>
            <td>{props.pretplata.trajanjeUgovora}</td>
            {(props.loginInfo?.isAdmin || props.loginInfo?.isUser) &&
                 <td><Button disabled={props.pretplata.tarifaIme === 'Vrabac max' || tryInfo} >Upgrade</Button></td>
                 }
            {props.loginInfo?.isAdmin && <td><Button variant="warning" onClick={() => goToEdit(props.pretplata)} >Edit</Button></td>}
            {props.loginInfo?.isAdmin && <td><Button variant="danger" onClick={() => deletePretplata(props.pretplata.id)}>Delete</Button></td>}
        </tr>
    )

}