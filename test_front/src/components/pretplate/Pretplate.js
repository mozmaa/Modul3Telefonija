import { useEffect, useState } from "react"
import TestAxios from "../../apis/TestAxios"
import { Col, FormCheck, FormLabel, Stack , Button} from "react-bootstrap"
import { Row } from "react-bootstrap"
import FormCheckInput from "react-bootstrap/esm/FormCheckInput"
import { Search } from "./Search"
import { Table } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import { PretplataRow } from "./PretplataRow"

export const Pretplate = (props) => {

    const[pretplate, setPretplate] = useState([])
    const [pageNo, setPageNo] = useState(0)
    const [pageCount, setPageCount] = useState(0)
    const [checked, setChecked] = useState(false)
    const [searchParams, setSearchParams] = useState({})
    const[tarife, setTarife] = useState([])
    const navigate = useNavigate()

    useEffect(() => {
        getPretplate(0)
        getTarife()
    }, [])

    const getTarife = () => {
        TestAxios.get('/tarife')
            .then(res => {
                setTarife(res.data)
            }).catch(error => {
                alert('Doslo je do greske!')
            })
    }

    const getPretplate = (newPageNo) => {

        const conf = {
            params: {
                ...searchParams,
                pageNo: newPageNo
            }
        }

        // console.log(conf)

        TestAxios.get('/pretplate', conf)
            .then(res => {
                console.log(res)
                setPretplate(res.data)
                setPageCount(Number(res.headers['total-pages']))
                setPageNo(newPageNo)
                
            }).catch(error => {
                console.log(error)
                alert('Doslo je do greske')
            })
    }

    const RenderPretplate = () => {
        return pretplate.map((pretplata,index) => {
            return (
            <PretplataRow key={index} pretplata={pretplata} editCallback={props.callback} 
                        loginInfo={props.loginInfo} pretplate={pretplate} deleteCallback={(pretplate) => setPretplate(pretplate)}
                        pageNo = {pageNo} getPretplateCallback={(pageNo) => {getPretplate(pageNo)}} >
            </PretplataRow>
            )
        })
    }

    const goToAdd = () => {
        navigate('/pretplate/dodavanje')
    }

    return (
        <Col>
            <Row><h1>Pretplate</h1></Row>
            <FormCheck>
                <FormCheckInput name="pretraga" onChange={(e) => setChecked(e.target.checked)}></FormCheckInput>
                <FormLabel htmlFor="pretraga">Prikazi pretragu</FormLabel>
            </FormCheck>
            {checked && <Search searchParamsCallback={(searchParams) => setSearchParams(searchParams)} 
                getPretplateCallback={(firstPage) => getPretplate(firstPage)} searchParams={searchParams} tarife={tarife}/>}
            <br></br>
            <Row><Col>
                <Table striped bordered hover bg="dark" variant="dark" id="linije=table">
                    <thead>
                        <tr>
                            <th>Korisnik</th>
                            <th>Provajder</th>
                            <th>Tarifa</th>
                            <th>Cena</th>
                            <th>Datum pocetka</th>
                            <th>Duzina trajanja</th>
                            {(props.loginInfo?.isAdmin || props.loginInfo?.isUser) && <th>Actions</th> }
                            {props.loginInfo?.isAdmin  && <th></th> }
                            {props.loginInfo?.isAdmin  && <th></th> }
                        </tr>
                    </thead>
                    <tbody>
                        {RenderPretplate()}
                    </tbody>
                </Table>
            </Col></Row>
            <Stack direction="horizontal" gap={3}>
                {props.loginInfo?.isAdmin ? <Button className="button button-navy" onClick={() => goToAdd()}>Add</Button> : <></>}
                <Button className="ms-auto" disabled={pageNo === 0} onClick={() => getPretplate(pageNo - 1)}>Prev</Button>
                {pretplate.length === 0 ? pageNo : pageNo + 1}/{pageCount}
                <Button disabled={pageNo === pageCount - 1} onClick={() => getPretplate(pageNo + 1)}>Next</Button>
            </Stack>
        </Col>
    )
}