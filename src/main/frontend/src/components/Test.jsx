import React, { Component } from "react";
import {
  Container,
  InputGroup,
  FormControl,
  Button,
  Form,
} from "react-bootstrap";
import { observer, inject } from "mobx-react";

@inject("authStore")
@observer
class Test extends Component {
  constructor(props) {
    super(props);
    const { authStore } = props;
    this.authStore = authStore;
  }
  render() {
    const { signin } = this.authStore;
    return (
      <Container>
        회원가입<br></br>
        <div className="small">* 항목은 필수입력 항목입니다.</div>
        <label>* 이름</label>
        <InputGroup className="mb-3">
          <FormControl aria-label="ID" aria-describedby="basic-addon2" />
          <InputGroup.Append>
            <Button variant="outline-secondary">중복확인</Button>
          </InputGroup.Append>
        </InputGroup>
        <label>* 이메일 주소</label>
        <InputGroup className="mb-3">
          <FormControl aria-label="ID" aria-describedby="basic-addon2" />
        </InputGroup>
        <label>* 비밀번호 입력</label>
        <InputGroup className="mb-3">
          <FormControl
            type="password"
            aria-label="password"
            aria-describedby="basic-addon2"
          />
          <InputGroup.Append>
            <Button variant="outline-secondary">확인</Button>
          </InputGroup.Append>
        </InputGroup>
        <InputGroup className="mb-3">
          <FormControl
            type="password"
            placeholder="비밀번호 재입력"
            aria-label="password"
            aria-describedby="basic-addon2"
          />

          <InputGroup.Append>
            <Button variant="outline-secondary">확인</Button>
          </InputGroup.Append>
        </InputGroup>
        <label>주소</label>
        <InputGroup className="mb-3">
          <FormControl aria-label="ID" aria-describedby="basic-addon2" />
        </InputGroup>
        <Form.Group controlId="formBasicCheckbox">
          <Form.Check
            type="checkbox"
            label="일단넣어놓은 체크박스(나중에 롤 대비)"
          />
        </Form.Group>
        <Button variant="secondary" onClick={() => signin()}>
          가입
        </Button>
        <Button variant="secondary">취소</Button>
      </Container>
    );
  }
}
export default Test;
